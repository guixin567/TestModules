package com.zhengyinuo.me.main.ui

import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.base.util.BottomNavigationViewUtil
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import route.Path

@Route(path = Path.me_main)
class MainActivity : BaseActivity() {
    private val model: MainViewModel by viewModels()

    override fun getLayoutId() = R.layout.activity_main

    override fun initData() {
        model.initData()
    }

    override fun initListener() {

        BottomNavigationViewUtil().bind(
            fragmentActivity = this,
            viewPager = vp_main,
            bottomNavigationView = bnv_main,
            fragmentBeans = model.fragmentBeans
        )

    }

}
