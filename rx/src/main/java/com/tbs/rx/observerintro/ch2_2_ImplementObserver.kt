package com.tbs.rx.observerintro

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

object ch2_2_ImplementObserver {
    @JvmStatic
    fun main(args: Array<String>) {
        val source = Observable.just("Alpha", "Beta", "Gamma")
        val observer = object : Observer<String> {
            override fun onComplete() {
                println("Done")
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: String?) {
                println("$t")
            }

            override fun onError(e: Throwable?) {
                e?.printStackTrace()
            }
        }
        source
            .map { s -> "Items sent:$s" }
            .subscribe(observer)
    }

}