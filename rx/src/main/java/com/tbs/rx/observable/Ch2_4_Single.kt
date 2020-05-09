package com.tbs.rx.observable

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import org.omg.CORBA.Object

/**
 *  Demonstrates Single,MayBe & Completed
 */
object Ch2_4_Single {
    @JvmStatic
    fun main(args: Array<String>) {
        /****************Single:Emits only once****************/
        val observer = object : SingleObserver<Int> {
            override fun onSuccess(t: Int?) {
                println("OnSuccess:$t")
            }

            override fun onError(e: Throwable?) {
                println("OnError:$e")
            }

            override fun onSubscribe(d: Disposable?) {
                println("onSubscribe")
            }
        }

        Single.just("Hello!")
            .map(String::length)
            .subscribe(observer)


    }
}