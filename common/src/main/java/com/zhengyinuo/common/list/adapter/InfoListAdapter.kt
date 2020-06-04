package com.zhengyinuo.common.list.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zhengyinuo.common.R
import com.zhengyinuo.common.list.InfoBean

class InfoListAdapter() :
    BaseQuickAdapter<InfoBean, BaseViewHolder>(R.layout.item_info) {
    override fun convert(holder: BaseViewHolder, item: InfoBean) {
        holder.getView<TextView>(R.id.tv_title).text = item.title
        holder.getView<TextView>(R.id.tv_content).text = item.content
    }
}