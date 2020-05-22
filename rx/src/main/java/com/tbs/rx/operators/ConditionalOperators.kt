package com.tbs.rx.operators

import io.reactivex.rxjava3.core.Observable

/**
 *  Emits or transforms the [Observable] conditionally
 *  i.e Adds decision making capability
 */
object ConditionalOperators {
    @JvmStatic
    fun main(args: Array<String>) {
        //takeWhile
        Observable.range(1, 100)
            .takeWhile { t -> t < 5 }
            .subscribe { t -> println(t) }

        println("========= SkipWhile===========")

        //skipWhile
        Observable.range(1, 100)
            .skipWhile { i -> i < 95 }
            .subscribe { t -> println(t) }

        println("========= defaultIfEmpty===========")
        val items = Observable.just("Alpha", "Beta", "Gamma")
        items.filter { s -> s.startsWith("Z") }
            .defaultIfEmpty("Not found")
            .subscribe { s -> println(s) }
        println("========= switchIfEmpty===========")
        val list = listOf<String>("Alpha", "Beta", "Gamma")
        val list1 = listOf<String>("ZAlpha", "ZBeta", "Gamma")

        Observable.fromIterable(list)
            .filter { s -> s.startsWith("Z") }
            .switchIfEmpty(Observable.fromIterable(list1))
            .filter { s -> s.startsWith("Z") }
            .subscribe { s -> println(s) }
    }
}