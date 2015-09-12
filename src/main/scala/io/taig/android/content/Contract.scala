package io.taig.android.content

abstract class Contract( implicit val context: android.app.Activity ) {
    def onViewCreated(): Unit = {}

    def onStart(): Unit = {}

    def onResume(): Unit = {}

    def onStop(): Unit = {}
}