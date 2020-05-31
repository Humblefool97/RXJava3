package com.tbs.rx.concurrency

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *  ObserveOn just takes the emission & then switched to a different thread mentioned
 */
fun main() {
    Observable.just("Alpha", "beta", "Gamma")
        .subscribeOn(Schedulers.io())
        .map { s ->
            println(Thread.currentThread().name)
            s
        }
        .observeOn(Schedulers.computation())
        .map { s -> "$s changed to ${Thread.currentThread().name}" }
        .blockingSubscribe {
            println(it)
        }

}