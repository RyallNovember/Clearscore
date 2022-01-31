package com.ryall.clearscore

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    companion object {
        lateinit var myApplication: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        myApplication = this
    }
}