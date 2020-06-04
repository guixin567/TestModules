package com.zhengyinuo.base.extension

import com.zhengyinuo.base.base.BaseApplication

fun Int.dp2px(): Float {
    return this * BaseApplication.instance!!.resources.displayMetrics.density + 0.5F
}