package com.zhengyinuo.base.extension

fun String?.default(value: String = ""): String {
    return this ?: value
}