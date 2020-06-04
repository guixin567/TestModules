package com.zhengyinuo.base.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
        initListener()
        initObserve()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun setActivityToolBar(toolbar: Toolbar?) {
        if (toolbar == null) return
        super.setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

    }

    //初始化视图
    open fun initView() {}

    //初始化数据
    open fun initData() {}

    //初始化事件
    open fun initListener() {}

    //初始化监听
    open fun initObserve() {}

    //布局ID
    abstract fun getLayoutId(): Int
}