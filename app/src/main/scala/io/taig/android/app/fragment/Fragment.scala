package io.taig.android.app.fragment

import io.taig.android.context.Contextual

trait Fragment extends android.support.v4.app.Fragment with Contextual {
  implicit override def context: android.app.Activity = getActivity
}
