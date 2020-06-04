package com.zhengyinuo.list.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhengyinuo.base.extension.default
import com.zhengyinuo.common.list.InfoBean
import route.IntentKey
import util.DataUtils

class ListViewModel : ViewModel() {
    private var categoryId: String? = null
    val listInfo = MutableLiveData<MutableList<InfoBean>>()

    fun initData(activity: ListActivity) {
        initIntent(activity)
        listInfo.value = DataUtils.getListInfoItemsWithCategoryId(categoryId)
    }

    private fun initIntent(activity: ListActivity) {
        categoryId = activity.intent.getStringExtra(IntentKey.categoryId).default()
    }
}