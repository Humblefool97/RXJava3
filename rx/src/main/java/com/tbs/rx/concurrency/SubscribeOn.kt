package com.tbs.rx.concurrency

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers


object SubscribeOn {
     fun <T> intenseCalculation(value: T): T {
        try {
            Thread.sleep(2000)
        } catch (exception: InterruptedException) {
            exception.printStackTrace()
        }
        return value
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val src = Observable.just("Alpha", "Beta", "Gamma")
            .subscribeOn(Schedulers.computation())
            .map {
                intenseCalculation(it)
            }
        val src1 = Observable.range(1, 3)
            .subscribeOn(Schedulers.computation())
            .map {
                intenseCalculation(it)
            }
        Observable.zip(src, src1, BiFunction { t1: String, t2: Int ->
            "$t1 - $t2"
        }).subscribe {
            println(it)
        }
        Thread.sleep(12000)
    }
}