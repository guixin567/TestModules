package com.zhengyinuo.me.main.home.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils
import com.zhengyinuo.base.extension.load
import com.zhengyinuo.common.me.BannerItemBean
import com.zhengyinuo.me.R

class HomeBannerAdapter(data: List<BannerItemBean>) :
    BannerAdapter<BannerItemBean, BannerViewHolder>(data) {


    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val imageView = BannerUtils.getView(parent!!, R.layout.item_image)
        return BannerViewHolder(imageView as ImageView)
    }

    override fun onBindView(
        holder: BannerViewHolder?,
        data: BannerItemBean?,
        position: Int,
        size: Int
    ) {
        holder?.view?.load(data?.imgUrl)
    }
}

class BannerViewHolder(var view: ImageView) : RecyclerView.ViewHolder(view)