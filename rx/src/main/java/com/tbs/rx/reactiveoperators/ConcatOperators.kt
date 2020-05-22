package com.tbs.rx.reactiveoperators

import com.tbs.rx.Logger
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 * It is very similar to merging operators
 * but here,the it emits the elements in the sequential order
 * of sources add
 */
object ConcatOperators {
    @JvmStatic
    fun main(args: Array<String>) {
        //concat factory
        Logger.printHeader("Concat factory")
        val source1 = Observable.just("First")
        val source2 = Observable.just("Second")
        Observable.concat(source1, source2)
            .subscribe(System.out::println)

        //Concat operator
        Logger.printHeader("Concat operator")
        source1.concatMap { source2 }
            .subscribe { s -> println(s) }

        Logger.printHeader("Concat Infinite obs")
        val tSourc1 = Observable.interval(1, TimeUnit.SECONDS)
            .map { l -> (l + 1) }
            .map { l -> "Source1:$l" }
            .take(2) //Try commenting out 2! It will block src2
        val tSourc2 = Observable.interval(300, TimeUnit.MILLISECONDS)
            .map { l -> (l + 1) * 300 }
            .map { l -> "Source2:$l" }

        Observable.concat(tSourc1, tSourc2)
            .subscribe(System.out::println)
        Thread.sleep(5 * 1000)
    }
}