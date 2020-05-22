package com.tbs.rx.reactiveoperators

import com.tbs.rx.Logger
import io.reactivex.rxjava3.core.Observable
import sun.rmi.runtime.Log
import java.util.concurrent.TimeUnit

/**
 * Combines data from different streams/events and make them work together
 */
object CombiningOperators {
    @JvmStatic
    fun main(args: Array<String>) {
        //Merge operators:Takes 2 or more observables,merges the O/p
        Logger.printHeader("Merge")
        val sr1 = Observable.just("Alpha", "Beta", "Gamma")
        val src2 = Observable.just("Delta", "Zeta", "Echo")
        Observable.merge(sr1, src2)
            .subscribe { s -> println(s) }
        //Another version
        Logger.printHeader("mergeWith operator")
        sr1.mergeWith(src2)
            .subscribe { s -> println(s) }
        //More than 4?Use mergeArray
        Logger.printHeader("mergeArray")
        val sr3 = Observable.just("Alpha1", "Beta1", "Gamma1")
        val src4 = Observable.just("Delta1", "Zeta1", "Echo1")
        val sr5 = Observable.just("Alpha2", "Beta2", "Gamma2")
        Observable.mergeArray(sr1, src2, sr3, src4, sr5)
            .subscribe { s -> println(s) }
        Logger.printHeader("mergeIterable")
        val list = listOf<Observable<String>>(sr1, src2, sr3, src4, sr5)
        Observable.merge(list)
            .subscribe { s -> println("Recieved : $s") }
        //Merge from inifinite Observable
        Logger.printHeader("from infinite observable")
        val obs1 = Observable.interval(1, TimeUnit.SECONDS)
            .map { l -> l + 1 }
            .map { l -> "Source1: $l seconds" }
        val obs2 = Observable.interval(300, TimeUnit.MILLISECONDS)
            .map { l -> (l + 1) * 300 }
            .map { l -> "Source2: $l seconds" }
        Observable.merge(obs1, obs2)
            .subscribe { s -> println(s) }
        Thread.sleep(3 * 1000)
    }
}