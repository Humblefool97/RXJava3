package com.tbs.rx.observable

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe

object Ch2_0_ObservableIntro {

    @JvmStatic
    fun main(args: Array<String>) {
        val source: @NonNull Observable<String>? =
            Observable.create(object : ObservableOnSubscribe<String> {

                override fun subscribe(emitter: ObservableEmitter<String>?) {
                    emitter?.onNext("Alpha")
                    emitter?.onNext("Beta")
                    emitter?.onNext("Gamma")
                    emitter?.onComplete()
                }
            })

        val lengthMap = source?.map { s ->
            s.length
        }
        val filter = lengthMap?.filter { i ->
            i >= 5
        }
        filter?.subscribe({ s ->
            println("Recieved: $s")
        }, Throwable::printStackTrace)
    }
}