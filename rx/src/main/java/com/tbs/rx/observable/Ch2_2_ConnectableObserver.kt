package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable

object Ch2_2_ConnectableObserver {
    @JvmStatic
    fun main(args: Array<String>) {
        val connectableObservable: ConnectableObservable<String> =
            Observable.just<String>("Alpha", "Beta", "Gamma").publish()
        connectableObservable.subscribe {
            println("First:$it")
        }
        connectableObservable
            .map { s -> s.hashCode() }
            .subscribe {
            println("Second:$it")
        }
        connectableObservable.connect()
    }
}