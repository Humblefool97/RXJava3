package com.tbs.rx.operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 *  Supresses emission when a certain condition is not met.
 *  Doesn't call onNext downstream for a disqualified emission
 */
object SuppressingOperators {

    @JvmStatic
    fun main(args: Array<String>) {
        //take:Takes the number of emissions
        println("============take(time,unit)==============")
        Observable.just("Alpha", "Beta", "Gamma")
            .take(2)
            .subscribe { s -> println(s) }
        println("============take(time,unit)==============")
        //take(time,unit) takes emissions only till specified time
        /*       Observable.interval(300, TimeUnit.MILLISECONDS)
                   .take(2, TimeUnit.SECONDS)
                   .subscribe { s -> println(s) }
               Thread.sleep(5 * 1000)*/
        println("============skip(count)==============")
        //Skip:Opposite of take(),ignores specified number of emissions
        Observable.range(1, 100)
            .skip(90)
            .subscribe { s -> println(s) }
        //distinct() : Skips all the duplicate emissions
        println("============distinct==============")
        val list = listOf<Int>(1, 1, 1, 2, 2, 3, 3, 3, 1)
        Observable.fromIterable(list)
            .distinct()
            .subscribe { s -> println(s) }
        println("============distinctUntilChanged==============")
        //distinctUntilChanged():Skips all the duplicate(consecutive)emissions,until
        //it encounters another distinctElement.But if repeated element reappears,it will still emit
        //until it appears consecutively
        val list1 = listOf<Int>(1, 1, 1, 2, 2, 3, 3, 3, 1)
        Observable.fromIterable(list1)
            .distinctUntilChanged()
            .subscribe { s -> println(s) }
        println("============elementAt==============")
        //elementAt() will print the element at a particular index
        //if the index doesnt exit,it wont print anything
        Observable.fromIterable(list)
            .elementAt(200)
            .subscribe { i -> print(i) }

        //elementAtOrError() will print the element at a particular index,if not error
        Observable.fromIterable(list)
            .elementAtOrError(3)
            .subscribe { t1, t2 ->
                println(t1)
                println(t2?.localizedMessage)
            }
    }

}
