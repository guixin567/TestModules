package com.zhengyinuo.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhengyinuo.base.extension.default
import com.zhengyinuo.common.list.InfoBean
import com.zhengyinuo.detail.ui.DetailActivity
import route.Param
import util.DataUtils

class DetailViewModel : ViewModel() {
    private var articleId: String? = null
    var detailBean = MutableLiveData<InfoBean>()

    fun initData(activity: DetailActivity) {
        initIntent(activity)
        detailBean.value = DataUtils.getListInfoItems().first { articleId == it.articleId }
    }

    private fun initIntent(activity: DetailActivity) {
        articleId = activity.intent.getStringExtra(Param.articleId).default()
    }
}