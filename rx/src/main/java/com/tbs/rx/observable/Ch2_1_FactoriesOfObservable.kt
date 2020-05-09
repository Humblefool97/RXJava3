package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Observable

object Ch2_1_FactoriesOfObservable {
    @JvmStatic
    fun main(args: Array<String>) {

        val items = listOf<String>("Alpha", "Beta", "Gamma")
        //We are going to use mostly this one
        Observable
            .fromIterable(items)
            .map { s -> s.length }
            .filter { i -> i >= 5 }
            .subscribe { s -> println("Items : $s") }

        //You can also use "Just".You can pass up to 10 items
        Observable
            .just("Alpha", "Beta", "Gamma")
            .subscribe { s -> println("Items in Just : $s") }
    }
}