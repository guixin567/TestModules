package com.zhengyinuo.me.main.home.adapter.listener

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.youth.banner.listener.OnBannerListener
import com.zhengyinuo.common.me.BannerItemBean
import com.zhengyinuo.me.main.ui.MainActivity

class BaseHomeAdapterListener(private val activity: FragmentActivity?) : HomeAdapterListener,
    OnBannerListener<BannerItemBean> {

    override fun OnBannerClick(data: BannerItemBean?, position: Int) {
        activity?.startActivity(Intent(activity, MainActivity::class.java))
    }

    override fun onBottomListClick(articleId: String?) {
        activity?.startActivity(Intent(activity, MainActivity::class.java))
    }
}