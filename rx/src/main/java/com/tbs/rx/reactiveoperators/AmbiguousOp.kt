package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *  Takes multiple subscribers.Waits till the first subscriber
 *  emits and then others are disposed of
 */
object AmbiguousOp {
    @JvmStatic
    fun main(args: Array<String>) {
        val src1 = Observable
            .interval(1, TimeUnit.SECONDS)
            .take(2)
            .map { i -> "Source1:$i seconds" }

        val src2 = Observable
            .interval(300, TimeUnit.MILLISECONDS)
            .take(5)
            .map { i -> "Source2:${i * 300} milliseconds" }

        Observable.amb(listOf(src1, src2))
            .subscribe { s -> println(s) }

        Thread.sleep(5 * 1000)
    }
}