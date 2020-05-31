package com.tbs.rx.concurrency

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

object BlockingOnSubscribe {
    @JvmStatic
    fun main(args: Array<String>) {
        val src = Observable.just("Alpha", "Beta", "Gamma")
            .subscribeOn(Schedulers.computation())
            .map {
                println(Thread.currentThread().name)
                SubscribeOn.intenseCalculation(it)
            }.blockingSubscribe {
                println("Printing on ${Thread.currentThread().name}")
                println(it)
            }
//        Thread.sleep(12000)
        println("Off the block")

    }
}