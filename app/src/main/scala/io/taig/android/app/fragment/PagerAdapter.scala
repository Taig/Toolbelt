package io.taig.android.app.fragment

import android.os.Parcelable
import android.support.v4.app.{FragmentManager, FragmentTransaction}
import android.view.{View, ViewGroup}

/**
  * An alternative FragmentPagerAdapter implementation, that allows to access the managed fragments
  */
abstract class PagerAdapter(manager: FragmentManager)
    extends android.support.v4.view.PagerAdapter {
  private var transaction: Option[FragmentTransaction] = None

  private var primary: Fragment = null

  private def getOrCreateTransaction = transaction match {
    case Some(transaction) ⇒ transaction
    case None ⇒
      val transaction = manager.beginTransaction()
      this.transaction = Some(transaction)
      transaction
  }

  def create(position: Int): android.support.v4.app.Fragment

  def get(position: Int): android.support.v4.app.Fragment =
    manager.findFragmentByTag(identifier(position))

  override def instantiateItem(container: ViewGroup, position: Int) = {
    val tag = identifier(position)

    val fragment = Option(get(position)) match {
      case Some(fragment) ⇒
        getOrCreateTransaction.attach(fragment)
        fragment
      case None ⇒
        val fragment = create(position)
        getOrCreateTransaction.add(container.getId, fragment, tag)
        fragment
    }

    if (fragment != primary) {
      fragment.setMenuVisibility(false)
    }

    fragment
  }

  override def destroyItem(container: ViewGroup,
                           position: Int,
                           `object`: Any) = {
    getOrCreateTransaction.detach(`object`.asInstanceOf[Fragment])
  }

  override def setPrimaryItem(container: ViewGroup,
                              position: Int,
                              `object`: Any) = {
    val fragment = `object`.asInstanceOf[Fragment]

    if (fragment != primary) {
      if (primary != null) {
        primary.setMenuVisibility(false)
      }

      if (fragment != null) {
        fragment.setMenuVisibility(true)
      }

      primary = fragment
    }
  }

  def getPrimaryItem = primary

  override def finishUpdate(container: ViewGroup) =
    transaction.foreach(transaction ⇒ {
      transaction.commitAllowingStateLoss()
      this.transaction = None
      manager.executePendingTransactions()
    })

  override def isViewFromObject(view: View, o: Any) = o match {
    case fragment: Fragment ⇒ fragment.getView == view
    case _ ⇒ false
  }

  def identifier(index: Int) = "taig:switcher:" + getClass.getName + ":" + index

  override def saveState() = null

  override def restoreState(state: Parcelable, loader: ClassLoader) = {}
}
