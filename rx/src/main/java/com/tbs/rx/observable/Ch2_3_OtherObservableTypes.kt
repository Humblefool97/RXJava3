package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import java.util.function.Supplier

object Ch2_3_OtherObservableTypes {
    @JvmStatic
    fun main(args: Array<String>) {
        //Range observable
        /* Observable.range(5, 10)
             .subscribe {
                 println("$it")
             }*/

        //Interval
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe { s ->
                println("${LocalDateTime.now().second} $s Bangalore")

            }
        Thread.sleep(3000)
        //Defer;Can react to changes in state of Observable
        var start = 1
        var count = 3
        val source: Observable<Int> = Observable.defer {
            Observable.range(start, count)
        }
        source.subscribe { i -> println("Observer 1: $i") }
        start = 10
        count = 10
        source.subscribe { i -> println("Observer 2: $i") }
    }

}
