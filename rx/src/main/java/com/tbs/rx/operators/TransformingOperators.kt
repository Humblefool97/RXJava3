package com.tbs.rx.operators

import com.tbs.rx.Logger
import io.reactivex.rxjava3.core.Observable

object TransformingOperators {
    @JvmStatic
    fun main(args: Array<String>) {
        //map:transforms from one form to other
        Logger.printHeader("map")
        Observable.just("Alpha", "Beta", "Gamma")
            .map { String::length }
            .subscribe { s -> Logger.printValue(s.toString()) }
        //cast():Use this when you want to cast an emission to something else
        Observable.just("Alpha", "Beta", "Gamma")
            .cast(Object::class.java)
        //startWithItem:Prepend an item before the first emission
        Observable.just("Masala Dosa", "Set Dosa", "Bisibele bath")
            .startWithItem("Vidyarthi Bhavan menu")
            .subscribe { s -> Logger.printValue(s) }
        // A variation of it can also be used to prepend an array or an Iterable
        val list = listOf<String>("Vidyarthi Bhavan menu", "-----------------")
        Observable.just("Masala Dosa", "Set Dosa", "Bisibele bath")
            .startWithIterable(list)
            .subscribe { s -> Logger.printValue(s) }
        //Sorted:Sorts the emission
        Observable.just(1, 2, 3, 4, 5)
            .sorted()
            .subscribe { s -> Logger.printValue(s.toString()) }
        /*Observable.just("Alpha","Beta","Gamma")
            .sorted(Comparator.comparingInt (String::length))*/
        //scan():Rolling aggregator.Can also provide initial value in one of the flavors
        Observable.just("Alpha", "Beta", "Gamma")
            .map(String::length)
            .scan { t1: Int, t2: Int -> t1 + t2 }
            .subscribe { i -> Logger.printValue(i.toString()) }
        //one more variant of scan,scan(initial value, (total,next) -> Int!)
        Observable.just("Alpha", "Beta", "Gamma")
            .scan(0) { total, next -> total + 1 }
            .subscribe { i -> Logger.printValue(i.toString()) }
    }
}