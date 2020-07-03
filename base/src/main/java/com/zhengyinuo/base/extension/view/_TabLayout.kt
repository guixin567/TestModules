package com.zhengyinuo.base.extension.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zhengyinuo.base.extension.default
import com.zhengyinuo.base.extension.getSafeItem

fun TabLayout.bindViewPager2(
    viewpager2: ViewPager2,
    fragmentBeans: MutableList<TabLayoutFragmentBean<out Fragment>>,
    fragmentActivity: FragmentActivity,
    onSelect: ((tab: TabLayout.Tab?) -> Unit)? = null
) {

    viewpager2.adapter = FragmentPageAdapter(fragmentBeans, fragmentActivity)
    fragmentBeans.forEach {
        addTab(newTab().setText(it.title.default()))
    }

    TabLayoutMediator(this, viewpager2) { tab, position ->
        tab.text = fragmentBeans.getSafeItem(position)?.title.default()
    }.attach()

    addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {}

        override fun onTabUnselected(tab: TabLayout.Tab?) {}

        override fun onTabSelected(tab: TabLayout.Tab?) {
            onSelect?.invoke(tab)
        }

    })
}

class FragmentPageAdapter(
    private val fragmentBeans: MutableList<TabLayoutFragmentBean<out Fragment>>,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = fragmentBeans.size
    override fun createFragment(position: Int) = fragmentBeans[position].fragment
}

class TabLayoutFragmentBean<T : Fragment>(var fragment: T, var title: String?)