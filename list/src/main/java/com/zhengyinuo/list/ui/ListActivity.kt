package com.zhengyinuo.list.ui

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.common.list.InfoBean
import com.zhengyinuo.common.list.adapter.InfoListAdapter
import com.zhengyinuo.list.R
import com.zhengyinuo.list.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_list.*
import route.Path
import route.routeToDetail

@Route(path = Path.list_list)
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
            routeToDetail(bean.articleId)
        }
    }

    override fun initObserve() {
        model.listInfo.observe(this, Observer {
            listAdapter.setNewInstance(it)
        })
    }
}
