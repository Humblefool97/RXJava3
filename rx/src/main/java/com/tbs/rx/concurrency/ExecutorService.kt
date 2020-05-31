package com.tbs.rx.concurrency

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executors

fun main() {
    val numOfThreads = 20
    val executorService = Executors.newFixedThreadPool(numOfThreads)
    val scheduler = Schedulers.from(executorService)

    Observable.just("Alpha", "Beta", "Gamma")
        .subscribeOn(scheduler)
        .doFinally(executorService::shutdown)
        .subscribe {
            println(it)
        }
}

