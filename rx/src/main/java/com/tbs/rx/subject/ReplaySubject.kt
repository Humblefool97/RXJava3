package com.tbs.rx.subject

import io.reactivex.rxjava3.subjects.ReplaySubject

/**
 *  ReplaySubject = PublishSubject + replay()
 */
object ReplaySubject {
    @JvmStatic
    fun main(args: Array<String>) {
        val replaySubject = ReplaySubject.create<Int>()
        replaySubject.subscribe {
            println("Sub1 : $it")
        }
        with(replaySubject) {
            for (i in 1..4) {
                onNext(i)
            }
        }
        replaySubject.subscribe {
            println("Sub2 : $it")
        }
    }
}