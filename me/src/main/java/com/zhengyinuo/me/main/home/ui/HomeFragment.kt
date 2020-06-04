package com.zhengyinuo.me.main.home.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhengyinuo.base.base.BaseFragment
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.home.adapter.HomeAdapter
import com.zhengyinuo.me.main.home.adapter.listener.BaseHomeAdapterListener
import com.zhengyinuo.me.main.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    private val model: HomeViewModel by viewModels()

    private val homeAdapter by lazy {
        HomeAdapter(listener = BaseHomeAdapterListener(activity))
    }

    companion object {
        fun instance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun initView() {
        rv_home.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
    }

    override fun initData() {
        model.initData()
    }

    override fun initObserve() {
        model.homeBeans.observe(this, Observer {
            homeAdapter.setNewInstance(it)
        })
    }

}