package com.example.fitnesstracker.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitnesstracker.RVFragmentMy.RVFragmentMy
import com.example.fitnesstracker.RVFragmentMy.RVFragmentUsers

class ViewPageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) RVFragmentMy() else RVFragmentUsers()
    }
}