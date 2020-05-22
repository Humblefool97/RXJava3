package com.tbs.rx

class Logger {
    companion object {
        fun printHeader(message: String) = println("============ ${message}==========")
        fun printValue(message: String) = println(message)
    }
}