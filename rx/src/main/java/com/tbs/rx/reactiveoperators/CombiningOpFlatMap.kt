package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function

/**
 *  Does dynamic merge.
 *  One of the major difference between map and flatmap,map emits values,flatmap emits observable
 */
object CombiningOpFlatMap {
    @JvmStatic
    fun main(args: Array<String>) {
        Observable.just("Alpha", "Beta", "Gamma")
            .flatMap { element -> Observable.fromArray(element.split("")) }
            .subscribe(System.out::println)
    }
}