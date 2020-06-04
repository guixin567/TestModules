package com.zhengyinuo.me.main.home.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.zhengyinuo.common.me.ProviderMultiBean
import com.zhengyinuo.me.main.home.adapter.listener.BaseHomeAdapterListener
import com.zhengyinuo.me.main.home.adapter.provider.HomeBannerProvider
import com.zhengyinuo.me.main.home.adapter.provider.HomeListProvider

class HomeAdapter(listener: BaseHomeAdapterListener) :
    BaseProviderMultiAdapter<ProviderMultiBean>() {


    override fun getItemType(data: List<ProviderMultiBean>, position: Int): Int {
        return data[position].type
    }

    init {
        addItemProvider(HomeBannerProvider(listener))
        addItemProvider(HomeListProvider(listener))
    }

}