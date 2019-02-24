package com.mutlu.turgay.kotlincleanarchitecturesample.base

import android.app.Application
import android.content.Context
import com.mutlu.turgay.kotlincleanarchitecturesample.base.network.Api


class App: Application(){
    init {
        instance = this
    }


    companion object {
        lateinit var instance:App

        fun applicationContext() : Context{
            return instance.applicationContext
        }
    }
}