package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.logging.Logger


object Ch1_1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val myStrings: Observable<String> = Observable.just("item1", "item2", "item3")
        myStrings.subscribe { s ->
            println("Next Event${s}")
        }
        myStrings.map { s -> s.length }
            .subscribe { s -> println("Next element : $s") }

        myStrings.subscribe(object : Observer<String> {
            override fun onComplete() {
                println("In onComplete")
            }

            override fun onSubscribe(d: Disposable?) {
                println("In onSubscribe")
            }

            override fun onNext(t: String?) {
                println("In onNext : $t")
            }

            override fun onError(e: Throwable?) {
                println("In onError : ${e?.localizedMessage}")
            }

        })
    }
}