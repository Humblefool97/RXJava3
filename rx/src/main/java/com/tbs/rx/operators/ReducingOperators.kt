package com.tbs.rx.operators

import io.reactivex.rxjava3.core.Observable

/**
 * Take emissions that are in series ,aggregate all of them and then return
 *  a [Single]
 */
object ReducingOperators {
    @JvmStatic
    fun main(args: Array<String>) {
        //:Similar to scan,but adds up all the values before emitting a single
        Observable.just(3, 3, 94)
            .reduce { total: Int, next: Int -> total + next }
            .subscribe { s -> println(s) }
        //reduce variant that can have a seed value
        Observable.just("Alpha", "Beta", "Gamma")
            .reduce("") { total: String, next: String ->
                val suffix = if (total == "")
                    ""
                else
                    ","
                (total + suffix) + next
            }
            .subscribe { s -> println(s) }
    }
}