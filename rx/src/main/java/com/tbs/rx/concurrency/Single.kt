package com.tbs.rx.concurrency

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


object Single {
    @JvmStatic
    fun main(args: Array<String>) {
        val scheduler = Schedulers.single()
        Observable.just("Alpha", "Beta", "Gamma", "Delta")
            .subscribeOn(scheduler)
            .map {
                "$it obtained on ${Thread.currentThread().name}"
            }
            .blockingSubscribe {
                println(it)
            }
    }
}