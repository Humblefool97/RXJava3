package com.tbs.rx

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object Playground {
    @JvmStatic
    fun main(args: Array<String>) {
        //Cold:Replays like a CD
        val src1 = Observable.interval(300,TimeUnit.MILLISECONDS)
        src1.subscribe{
            println("Source1: $it")
        }
        Thread.sleep(1000)

        src1.subscribe{
            println("Source2: $it")
        }

        Thread.sleep(3000)

        Logger.printHeader("Range")
        val src2 = Observable.range(1,5)
        src2.subscribe {
            println("Src1:$it")
        }
        src2.subscribe {
            println("Src2:$it")
        }

        //Converting cold to hot
        Logger.printHeader("Cold to Hot")
        val connectableObservable = Observable.range(1,5).publish()
        connectableObservable.subscribe {
            println("Src1:$it")
        }
        connectableObservable.subscribe {
            println("Src2:$it")
        }
        connectableObservable.connect()

    }
}