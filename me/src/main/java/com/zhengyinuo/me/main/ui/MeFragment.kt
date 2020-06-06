package com.zhengyinuo.me.main.ui

import com.zhengyinuo.base.base.BaseFragment
import com.zhengyinuo.me.R

class MeFragment : BaseFragment() {
    companion object {
        fun instance(): MeFragment {
            return MeFragment()
        }
    }

    override fun getLayoutId() = R.layout.fragment_me
}