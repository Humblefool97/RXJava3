package com.tbs.rx.operators

import io.reactivex.rxjava3.core.Observable

object UtilityOperators {
    @JvmStatic
    fun main(args: Array<String>) {
        Observable.just("Alpha","Beta","Gamma")
            .repeat(3)
            .subscribe { s->
                println(s)
            }
    }
}