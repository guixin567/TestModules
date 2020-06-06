package com.zhengyinuo.testmodules

import com.alibaba.android.arouter.launcher.ARouter
import com.zhengyinuo.base.base.BaseApplication

class MyApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}