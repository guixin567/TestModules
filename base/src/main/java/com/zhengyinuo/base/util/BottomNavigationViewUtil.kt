package com.zhengyinuo.base.util

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zhengyinuo.base.base.bean.FragmentBean
import com.zhengyinuo.base.extension.getSafeItem

class BottomNavigationViewUtil {

    fun bind(
        fragmentActivity: FragmentActivity,
        viewPager: ViewPager2,
        bottomNavigationView: BottomNavigationView,
        fragmentBeans: MutableList<FragmentBean>?
    ) {

        viewPager.adapter = object : FragmentStateAdapter(fragmentActivity) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int) =
                fragmentBeans.getSafeItem(position)!!.fragment
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val bean = fragmentBeans.getSafeItem(position)
                bottomNavigationView.selectedItemId = bean!!.itemId
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener {
            val bean = fragmentBeans!!.first { bean -> it.itemId == bean.itemId }
            viewPager.setCurrentItem(bean.index, false)
            true
        }
    }
}