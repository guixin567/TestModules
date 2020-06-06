package com.zhengyinuo.base.base

import android.app.Application

open class BaseApplication : Application() {
    companion object {
        var instance: BaseApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}