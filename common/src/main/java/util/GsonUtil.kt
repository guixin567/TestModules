package util

import com.google.gson.Gson
import com.google.gson.GsonBuilder


/**
 * Created on 2016/11/15 16:49.
 * Project android_zzkko
 * Copyright (c) 2016 zzkko Inc. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * *                #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #              hello         world                  #
 * #                                                   #
 */
object GsonUtil {
    private var mGson: Gson? = null
    val gson: Gson
        get() {
            if (mGson == null) {
                mGson = GsonBuilder()
                    .registerTypeAdapter(String::class.java, StringDefaultAdapter())
                    .create()
            }
            return mGson!!
        }
}