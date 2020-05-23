package com.tbs.rx.reactiveoperators

import com.tbs.rx.Logger
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 * Caches the emissions & Re-emits to the next observer
 */
object Replay {
    @JvmStatic
    fun main(args: Array<String>) {
        /*  val src1 = Observable.interval(1, TimeUnit.SECONDS)
              .map { i -> i + 1 }
              .replay()
              .autoConnect()

          src1.subscribe {
              println("Src1: ${it}  seconds")
          }
          Thread.sleep(3 * 1000)
          src1.subscribe {
              println("Src2: ${it} seconds")
          }
          Thread.sleep(3 * 1000)*/

        Logger.printHeader("Replay with buffer")
        val src2 = Observable.interval(1, TimeUnit.SECONDS)
            .map { i -> i + 1 }
            .replay(2)
            .autoConnect()

        src2.subscribe {
            println("Src1: ${it}  seconds")
        }
        Thread.sleep(3 * 1000)
        src2.subscribe {
            println("Src2: ${it} seconds")
        }
        Thread.sleep(3 * 1000)
    }
}