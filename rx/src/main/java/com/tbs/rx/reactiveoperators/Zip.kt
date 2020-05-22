package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Function3
import java.time.LocalTime
import java.util.concurrent.TimeUnit

/*Take emission from each source,combine them in to one!
When one of them sends an onComplete , it stops zipping.
The emissions of others which are yet to emit are dropped as they have nothing to be paired with*/

object Zip {
    @JvmStatic
    fun main(args: Array<String>) {
        val src1 =
            Observable.just("Alpha", "Beta", "Gamma")
        val src2 =
            Observable.range(1, 6)
        val src3 = Observable.just("Alpha1", "Beta1", "Gamma1")

        Observable.zip(
            src1,
            src2,
            src3,
            Function3 { s: String, i: Int, t: String -> "$s-$i-$t" }
        ).subscribe { s -> println(s) }

        //Zipping slows down the emmissions of the faster observable
        val src4 = Observable.just("Alpha", "Beta", "Gamma")
        val src5 = Observable.interval(1, TimeUnit.SECONDS)
            .map { i -> i + 1 }
        Observable.zip(
            src4,
            src5,
            BiFunction { t1: String, t2: Long -> "Src4:$t1 with Src5:$t2 emitted @${LocalTime.now()}" })
            .subscribe { s -> println(s) }
        Thread.sleep(3 * 1000)
    }
}