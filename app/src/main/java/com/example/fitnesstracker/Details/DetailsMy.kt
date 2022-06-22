package com.example.fitnesstracker.Details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.Data.DataActivityMy
import com.example.fitnesstracker.ListItem
import com.example.fitnesstracker.R

class DetailsMy: Fragment(R.layout.activity_fragment_my_detalization) {

    companion object {
        const val KEY_NAME = "name"
    }

    private val myActivityDataRepository = DataActivityMy()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        setHasOptionsMenu(true)

        val activityId = requireArguments().getInt(KEY_NAME)
        val activityData: ListItem.Card = myActivityDataRepository.getData()[activityId] as ListItem.Card
        view.findViewById<TextView>(R.id.distanceText).text = activityData.distance
        view.findViewById<TextView>(R.id.timeText).text = activityData.time
        view.findViewById<TextView>(R.id.dateText).text = activityData.date
        toolbar.title = activityData.kindSport
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_details_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}