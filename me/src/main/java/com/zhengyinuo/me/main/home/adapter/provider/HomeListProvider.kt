package com.zhengyinuo.me.main.home.adapter.provider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zhengyinuo.common.list.InfoBean
import com.zhengyinuo.common.list.adapter.InfoListAdapter
import com.zhengyinuo.common.me.HomeListBean
import com.zhengyinuo.common.me.ProviderMultiBean
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.home.adapter.listener.BaseHomeAdapterListener

class HomeListProvider(private val listener: BaseHomeAdapterListener) :
    BaseItemProvider<ProviderMultiBean>() {

    override val itemViewType = ProviderMultiBean.listType

    override val layoutId = R.layout.home_list

    override fun convert(helper: BaseViewHolder, item: ProviderMultiBean) {
        item as HomeListBean
        val rvBottom = helper.getView<RecyclerView>(R.id.rv_bottom)
        rvBottom.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = InfoListAdapter().apply {
                setNewInstance(item.beans)
                setOnItemClickListener { adapter, _, position ->
                    val bean = adapter.data[position] as InfoBean
                    listener.onBottomListClick(bean.articleId)
                }
            }
        }
    }


}