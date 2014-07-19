package com.taig.android.view

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.ImageView
import com.taig.android.{R, Color}

class	ColorCircle( context: Context, private var color: Color, attributes: AttributeSet, style: Int )
extends	ImageView( context, attributes, style )
{
	def this( context: Context ) = this( context, Color.White, null, 0 )

	def this( context: Context, attributes: AttributeSet ) = this( context, Color.White, attributes, 0 )

	def this( context: Context, attributes: AttributeSet, style: Int ) = this( context, Color.White, attributes, style )

	def this( context: Context, color: Color ) = this( context, color, null, 0 )

	lazy val check = context
		.getResources
		.getDrawable( R.drawable.color_picker_preference_circle )

	val circle = context
		.getResources
		.getDrawable( R.drawable.color_picker_preference_circle )
		.mutate()
		.asInstanceOf[GradientDrawable]

	val size = circle.getIntrinsicWidth

	setBackground( circle )
	setColor( color )

	def getColor = color

	def setColor( color: Color )
	{
		this.color = color
		circle.setColor( color )
	}

	def setStrokedColor( color: Color )
	{
		setColor( color )
		circle.setStroke( size / 8, color.darken( 0.25f ) )
	}

	def isActive = getDrawable != null

	def setActive( active: Boolean ) = setImageDrawable( if( active ) check else null )

	def activate() = setActive( true )

	def deactivate() = setActive( false )

	override def onMeasure( widthMeasureSpec: Int, heightMeasureSpec: Int ) = setMeasuredDimension( size, size )
}