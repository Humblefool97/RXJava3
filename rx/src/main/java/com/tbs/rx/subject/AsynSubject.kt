package com.tbs.rx.subject

import io.reactivex.rxjava3.subjects.AsyncSubject

/**
 *  Emits only the last element.
 *  Calling onComplete is a must otherwise it wont emit
 */
object AsyncSubject {
    @JvmStatic
    fun main(args: Array<String>) {
        val asyncSubject = AsyncSubject.create<Int>()
        asyncSubject.subscribe {
            println("Sub1:- $it")
        }
        with(asyncSubject) {
            for (i in 1..4)
                onNext(i)
            onComplete()
        }
        asyncSubject.subscribe {
            println("Sub2:- $it")
        }
    }
}