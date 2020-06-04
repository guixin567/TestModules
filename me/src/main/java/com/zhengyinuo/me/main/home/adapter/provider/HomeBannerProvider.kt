package com.zhengyinuo.me.main.home.adapter.provider

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import com.zhengyinuo.common.me.HomeBannerBean
import com.zhengyinuo.common.me.ProviderMultiBean
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.home.adapter.HomeBannerAdapter
import com.zhengyinuo.me.main.home.adapter.listener.BaseHomeAdapterListener

class HomeBannerProvider(private val listener: BaseHomeAdapterListener) :
    BaseItemProvider<ProviderMultiBean>() {

    override val itemViewType = ProviderMultiBean.bannerType

    override val layoutId = R.layout.home_banner

    override fun convert(helper: BaseViewHolder, item: ProviderMultiBean) {
        val banner = helper.getView<Banner<ProviderMultiBean, HomeBannerAdapter>>(R.id.banner)
        item as HomeBannerBean
        banner//添加生命周期观察者
            .setAdapter(
                HomeBannerAdapter(
                    item.banners ?: mutableListOf()
                )
            )
            .setIndicator(CircleIndicator(context))
            .setOnBannerListener(listener)
            .start();
    }


}