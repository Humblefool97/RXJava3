package com.tbs.rx.reactiveoperators

import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

/**
 *  Converting a cold to a hot observable is called Multicasting
 *  Helps to single stream of emissions to both the subscribers instead of 2
 *  Do it only for performance reasons and when multiple recievers recievingh the
 *  same data simultaneously
 */
object Multicasting {

    @JvmStatic
    fun main(args: Array<String>) {
        val connectableObservable = Observable.range(1, 5).map {
            Random(1).nextInt()
        }.publish()

        connectableObservable.subscribe {
            println("Src1: $it")
        }
        connectableObservable.subscribe {
            println("Src2: $it")
        }
        connectableObservable.connect()
    }
}