package com.example.whattodo

import android.app.Application
import com.example.whattodo.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WhatApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(mainModule)
        }
    }
}