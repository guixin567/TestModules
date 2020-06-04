package com.zhengyinuo.me.main.ui

import com.zhengyinuo.base.base.BaseFragment
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.home.ui.HomeFragment

class PlanFragment : BaseFragment() {
    companion object {
        fun instance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayoutId() = R.layout.fragment_plan
}