package com.zhengyinuo.base.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imgUrl: String?) {
    if (imgUrl.isNullOrEmpty()) return
    Glide.with(context).load(imgUrl).into(this)
}