package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable

/**
 *  Caching for infinite observable
 */
object Caching {
    @JvmStatic
    fun main(args: Array<String>) {
        val src1 = Observable.just(1, 2, 3, 4, 5)
            .scan(0) { total, next ->
                total + next
            }.cache()

        src1.subscribe {
            println("Source1: ${it}")
        }
        src1.subscribe {
            println("Source2:$it")
        }
    }
}