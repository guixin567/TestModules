package com.zhengyinuo.list.ui

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.common.list.InfoBean
import com.zhengyinuo.common.list.adapter.InfoListAdapter
import com.zhengyinuo.list.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    private val model: ListViewModel by viewModels()

    private val listAdapter by lazy { InfoListAdapter() }

    override fun getLayoutId() = R.layout.activity_list

    override fun initView() {
        setActivityToolBar(tool_bar)
        rv_info.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

    override fun initData() {
        model.initData(this)
    }

    override fun initListener() {
        listAdapter.setOnItemClickListener { adapter, _, position ->
            val bean = adapter.data[position] as InfoBean
        }
    }

    override fun initObserve() {
        model.listInfo.observe(this, Observer {
            listAdapter.setNewInstance(it)
        })
    }
}
