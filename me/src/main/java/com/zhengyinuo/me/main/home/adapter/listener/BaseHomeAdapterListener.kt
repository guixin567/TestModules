package com.zhengyinuo.me.main.home.adapter.listener

import androidx.fragment.app.FragmentActivity
import com.youth.banner.listener.OnBannerListener
import com.zhengyinuo.common.me.BannerItemBean
import route.routeToDetail
import route.routeToList

class BaseHomeAdapterListener(private val activity: FragmentActivity?) : HomeAdapterListener,
    OnBannerListener<BannerItemBean> {

    override fun OnBannerClick(data: BannerItemBean?, position: Int) {
        routeToList(data?.categoryId)
    }

    override fun onBottomListClick(articleId: String?) {
        routeToDetail(articleId)
    }
}