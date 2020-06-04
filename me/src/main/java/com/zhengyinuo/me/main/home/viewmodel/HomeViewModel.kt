package com.zhengyinuo.me.main.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhengyinuo.common.me.ProviderMultiBean
import util.DataUtils

class HomeViewModel : ViewModel() {
    val homeBeans = MutableLiveData<MutableList<ProviderMultiBean>>()
    fun initData() {
        homeBeans.value = mutableListOf(
            DataUtils.getHomeBannerBean(),
            DataUtils.getHomeListBean()
        )
    }
}