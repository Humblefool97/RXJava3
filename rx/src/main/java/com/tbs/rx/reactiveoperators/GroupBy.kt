package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable

/**
 *  Groups observables based on a specified key
 *  in to separate Observables
 */
object GroupBy {
    @JvmStatic
    fun main(args: Array<String>) {
        //Grouping numbers by even or oddness
        val src = Observable.range(1, 100)
        src.groupBy {
            if (it % 2 == 0)
                "E"
            else
                "O"
        }.flatMapSingle {
            it.toList()
        }.subscribe(System.out::println)

        //Grouping numbers by length
        val src1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        src1.groupBy {
            it.length
        }.flatMapSingle {
            it.toList()
        }.subscribe(System.out::println)
    }
}