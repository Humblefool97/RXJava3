package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import java.util.concurrent.TimeUnit

/**
 *  Pretty much like Zip,but doesnt queue until one emits.
 *  As long as there is one emission from each in starting,it combines the
 *  latest from one to latest to other
 *
 *  http://reactivex.io/documentation/operators/combinelatest.html
 */
object CombineLatest {
    @JvmStatic
    fun main(args: Array<String>) {
        val src1 = Observable.interval(300, TimeUnit.MILLISECONDS)
        val src2 = Observable.interval(1, TimeUnit.SECONDS)
        Observable.combineLatest(src1, src2, BiFunction { src1: Long, src2: Long ->
            "Source1 : $src1 Source2:$src2"
        }).subscribe(System.out::println)

        Thread.sleep(3 * 1000)
    }
}