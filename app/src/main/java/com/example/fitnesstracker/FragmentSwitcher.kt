package com.example.fitnesstracker

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.fitnesstracker.Adapters.ViewPageAdapter

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FragmentSwitcher: Fragment(R.layout.activity_fragment_switcher)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titles = arrayOf("Моя", "Пользователей")

        val viewPageAdapter = ViewPageAdapter(this)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = viewPageAdapter

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}