package com.tbs.rx.subject

import io.reactivex.rxjava3.subjects.BehaviorSubject

/**
 *  This is Subject similar to calling replay(1).autoConnect()
 *  Just emits the last emission to subscriber downstream
 */
object BehaviorSubject {
    @JvmStatic
    fun main(args: Array<String>) {
        val behaviorSubject = BehaviorSubject.create<Int>()
        behaviorSubject.subscribe {
            println("sub1: $it")
        }
        with(behaviorSubject) {
            onNext(1)
            onNext(2)
            onNext(3)
            onNext(4)
        }
        behaviorSubject.subscribe {
            println("sub2: $it")
        }
    }
}