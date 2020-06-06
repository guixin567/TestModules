package com.zhengyinuo.me.main.ui

import com.zhengyinuo.base.base.BaseFragment
import com.zhengyinuo.me.R

class PlanFragment : BaseFragment() {
    companion object {
        fun instance(): PlanFragment {
            return PlanFragment()
        }
    }

    override fun getLayoutId() = R.layout.fragment_plan
}