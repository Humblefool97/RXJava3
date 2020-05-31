package com.tbs.rx.subject

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject

object Publish {
    @JvmStatic
    fun main(args: Array<String>) {
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.subscribe {
            println("1st observer: $it")
        }
        with(publishSubject) {
            onNext(1)
            onNext(2)
            onNext(3)
        }

        publishSubject.subscribe {
            println("2nd observer: $it")
        }
        publishSubject.onNext(4)
        publishSubject.onComplete()
    }
}