package com.example.fitnesstracker.RVFragmentMy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.Adapters.RecyclerAdapter
import com.example.fitnesstracker.Data.DataActivityMy
import com.example.fitnesstracker.R

class RVFragmentMy: Fragment(R.layout.fragment_switch_my)  {

    private val myActivityData = DataActivityMy()
    private val adapter = RecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@RVFragmentMy.adapter
        }
        adapter.setData(myActivityData.getData())
    }
}