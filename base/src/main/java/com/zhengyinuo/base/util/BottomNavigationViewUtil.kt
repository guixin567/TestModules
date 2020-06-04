package com.zhengyinuo.base.util

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zhengyinuo.base.base.bean.FragmentBean

class BottomNavigationViewUtil {

    fun bind(
        fragmentActivity: FragmentActivity,
        viewPager: ViewPager2,
        bottomNavigationView: BottomNavigationView,
        fragmentBeans: MutableList<FragmentBean>
    ) {

        viewPager.adapter = object : FragmentStateAdapter(fragmentActivity) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int) = fragmentBeans[position].fragment
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            val bean = fragmentBeans.first { bean -> it.itemId == bean.itemId }
            viewPager.setCurrentItem(bean.index, false)
            true
        }
    }
}