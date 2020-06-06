package com.zhengyinuo.base.extension

fun <T> List<T>?.default(): List<T> {
    return this ?: mutableListOf()
}

fun <T> List<T>?.getSafeItem(position: Int): T? {
    if (this == null) return null
    if (position in 0 until size) {
        return get(position)
    }
    return null
}