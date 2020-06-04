package com.zhengyinuo.me.main.ui

import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.base.base.bean.FragmentBean
import com.zhengyinuo.base.util.BottomNavigationViewUtil
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.home.ui.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_main


    override fun initListener() {

        val fragmentBeans = mutableListOf(
            FragmentBean(HomeFragment.instance(), R.id.home, 0),
            FragmentBean(PlanFragment.instance(), R.id.plan, 1),
            FragmentBean(MeFragment.instance(), R.id.me, 2)
        )

        BottomNavigationViewUtil().bind(
            fragmentActivity = this,
            viewPager = vp_main,
            bottomNavigationView = bnv_main,
            fragmentBeans = fragmentBeans
        )

    }

}
