package io.taig.android.concurrent.app.contract

import io.taig.android.app.contract.Contract
import io.taig.android.log.Log

import scala.language.implicitConversions

trait Job[T] extends Contract {
    protected implicit def `=> PartialFunction[T, Unit]`[U]( f: ⇒ U ): PartialFunction[T, Unit] = { case _ ⇒ f }

    /**
     * Handle the response
     *
     * If the given PartialFunction is not defined for the request response, an UnexpectedResult or UnexpectedApiResponse
     * will we raised and forwarded to onFailure
     *
     * Do not call super.onSuccess when overriding this method
     */
    def onSuccess: PartialFunction[T, Unit] = {}

    /**
     * Handle failure that occurred during the request
     *
     * Make sure to call super.onFailure when overriding this method
     */
    def onFailure( exception: Throwable ): Unit = exception match {
        case _ ⇒ Log.e( "Job failed", exception )( Log.Tag( context.getClass.getName ) )
    }
}