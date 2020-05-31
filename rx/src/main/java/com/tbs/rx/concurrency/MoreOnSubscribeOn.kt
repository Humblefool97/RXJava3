package com.tbs.rx.concurrency

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *  The order / place where you put subscribe on doesnt matter
 *  It always tells the Observable to emit items on the thread mentioned while
 *  [SubscribeOn]
 *
 *  Also,if you multiple [SubscribeOn] the topmost or the one closest to the source [Observable]
 *  takes precedence
 */
fun main() {
    val source = Observable
        .just("Alpha", "Beta", "Gamma")
        .map {
            val threadString = "$it is emitted on ${Thread.currentThread().name}"
            SubscribeOn.intenseCalculation(threadString)
        }
        .subscribeOn(Schedulers.computation())
        .blockingSubscribe() {
            println(it)
        }
    val secondSource = Observable
        .just("Alpha", "Beta", "Gamma")
        .subscribeOn(Schedulers.computation())
        .map {
            val threadString = "$it is emitted on ${Thread.currentThread().name}"
            SubscribeOn.intenseCalculation(threadString)
        }
        .blockingSubscribe {
            println(it)
        }
}