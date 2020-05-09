package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Close cousin to [Ch2_4_Single] but also allows "no emission"
 *
 *
 */
object Ch2_5_Maybe {
    @JvmStatic
    fun main(args: Array<String>) {
        val maybeObserver: MaybeObserver<String> = object : MaybeObserver<String> {
            override fun onSuccess(t: String?) {
                println("onSuccess :- $t")
            }

            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable?) {
                println("onSubscribe")
            }

            override fun onError(e: Throwable?) {
                e?.printStackTrace()
            }
        }

        val maybeSource = Maybe.just("Hello!")
        maybeSource.subscribe(maybeObserver)
        val maybeEmptySource: Maybe<String> = Maybe.empty()
        maybeEmptySource.subscribe(maybeObserver)
    }
}