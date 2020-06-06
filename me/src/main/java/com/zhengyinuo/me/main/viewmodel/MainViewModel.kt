package com.zhengyinuo.me.main.viewmodel

import androidx.lifecycle.ViewModel
import com.zhengyinuo.base.base.bean.FragmentBean
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.home.ui.HomeFragment
import com.zhengyinuo.me.main.ui.MeFragment
import com.zhengyinuo.me.main.ui.PlanFragment

class MainViewModel : ViewModel() {
    var fragmentBeans: MutableList<FragmentBean>? = null
    fun initData() {
        fragmentBeans = mutableListOf(
            FragmentBean(HomeFragment.instance(), R.id.home, 0),
            FragmentBean(PlanFragment.instance(), R.id.plan, 1),
            FragmentBean(MeFragment.instance(), R.id.me, 2)
        )
    }
}