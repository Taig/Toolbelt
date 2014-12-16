package com.taig.android.widget

import android.content.Context
import android.content.res.TypedArray
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v4.view.ViewPager.OnPageChangeListener
import android.util.{AttributeSet, Log}
import android.view.MotionEvent
import com.taig.android._
import com.taig.android.content.fragment.Paged
import com.taig.android.widget.Pager.Tag

import scala.collection.mutable

/**
 * A ViewPager implementation that allows to enable and disable swipe navigation
 */
class	Pager( val attributes: AttributeSet = null )( implicit context: Context )
extends	ViewPager( context, attributes )
with	Widget
{
	def this( context: Context, attributes: AttributeSet ) = this( attributes )( context )

	def this( context: Context ) = this()( context )

	/**
	 * Index of the previously focused fragment
	 */
	private var previous: Option[Int] = None

	private var swipe = true

	private val listeners = mutable.ListBuffer[ViewPager.OnPageChangeListener]()

	initialize( R.styleable.View_Pager, ( array: TypedArray ) =>
	{
		swipe = array.getBoolean( R.styleable.View_Pager_swipe, swipe )
	} )

	super.setOnPageChangeListener( Listener )

	override def onAttachedToWindow()
	{
		super.onAttachedToWindow()

		if( getCurrentItem == 0 )
		{
			triggerFocusEvents()
		}
	}

	protected def triggerFocusEvents() =
	{
		getAdapter match
		{
			case adapter: FragmentPagerAdapter =>
			{
				previous.map( adapter.getItem ) match
				{
					case Some( fragment: Paged ) => fragment.onPagerUnfocused()
					case _ => // Nothing to do
				}

				adapter.getItem( getCurrentItem ) match
				{
					case fragment: Paged => fragment.onPagerFocused()
					case _ => // Nothing to do
				}
			}
			case _ => Log.w(
				Tag,
				"Not using ViewPager with FragmentPagerAdapter does not support Fragment pager lifecycle events"
			)
		}

		previous = Some( getCurrentItem )
	}

	def isSwipeEnabled = swipe

	def setSwipeEnabled( enabled: Boolean ) = swipe = enabled

	override def onTouchEvent( event: MotionEvent ) = if( swipe ) super.onTouchEvent( event ) else false

	override def onInterceptTouchEvent( event: MotionEvent ) =
	{
		if( swipe ) super.onInterceptTouchEvent( event ) else false
	}

	override def setOnPageChangeListener( listener: OnPageChangeListener ) = if( listener != null )
	{
		addOnPageChangeListener( listener )
	}

	def addOnPageChangeListener( listener: OnPageChangeListener ) = listeners += listener

	def removeOnPageChangeListener( listener: OnPageChangeListener ) = listeners -= listener

	private object	Listener
	extends			ViewPager.OnPageChangeListener
	{
		override def onPageScrolled( position: Int, offset: Float, positionOffsetPixels: Int )
		{
			listeners.foreach( _.onPageScrolled( position, offset, positionOffsetPixels ) )
		}

		override def onPageSelected( position: Int )
		{
			triggerFocusEvents()
			listeners.foreach( _.onPageSelected( position ) )
		}

		override def onPageScrollStateChanged( state: Int ) = listeners.foreach( _.onPageScrollStateChanged( state ) )
	}
}

object Pager
{
	val Tag = classOf[Pager].getName
}