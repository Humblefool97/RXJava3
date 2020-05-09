package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

/**
 *  Link between [Observable] & an active [Observer] . Call [Disposable]'s dispose method to stop emissions and dispose of all resources
 *  used for the observer
 *
 *  Why?
 *  Whenever an [Observable] is subsribed ,a stream is formed to process the emissions  through an Observerbale chain.This uses resources
 *  We need to clear of these resources as soon as we are done.
 *
 *  If it's a finite [Observable] , then garbage collector handles it (after onCompleted) . but in case of finite or long running observable,
 *  we might have to stop emissions explicitly and dispose of everything related to subsrciption,to avaoid mem leaks.Can't trust grabage collector
 *
 */
object Disposable {

    @JvmStatic
    fun main(args: Array<String>) {
        val seconds: Observable<Long> = Observable.interval(1, TimeUnit.SECONDS)
        val disposable = seconds.subscribe {
            println("value: $it")
        }
        Thread.sleep(5 * 1000)
        disposable.dispose()
        println("Is disposed : ${disposable.isDisposed}")
        Thread.sleep(5 * 1000)

        //Composite Disposable
        val compositeDisposable = CompositeDisposable()

        val disposable1 = seconds.subscribe { count -> println(count) }
        val disposable2 = seconds.subscribe { count -> println(count) }
        //Notice when you try to dispose a disposable which is already disposed
        compositeDisposable.addAll(disposable1, disposable2, disposable)
        Thread.sleep(5 * 1000)
        compositeDisposable.dispose()
        println("Is disposable1 disposed : ${disposable1.isDisposed}")

        println("Is disposable2 disposed : ${disposable2.isDisposed}")
        Thread.sleep(5 * 1000)
    }
}