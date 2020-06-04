package com.zhengyinuo.detail.ui

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.detail.R
import com.zhengyinuo.detail.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {
    private val model: DetailViewModel by viewModels()

    override
    fun getLayoutId() = R.layout.activity_detail

    override fun initData() {
        model.initData(this)
    }

    override fun initObserve() {
        model.detailBean.observe(this, Observer {
            tv_title.text = it.title
            tv_content.text = it.content
        })

    }
}
