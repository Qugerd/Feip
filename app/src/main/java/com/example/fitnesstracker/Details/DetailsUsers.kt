package com.example.fitnesstracker.Details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.Data.DataActivityUsers
import com.example.fitnesstracker.ListItem
import com.example.fitnesstracker.R

class DetailsUsers: Fragment(R.layout.activity_fragment_users_detalization) {

    companion object {
        const val KEY_NAME = "name"
    }

    private val usersActivityDataRepository = DataActivityUsers()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val activityId = requireArguments().getInt(DetailsMy.KEY_NAME)
        val activityData: ListItem.Card = usersActivityDataRepository.getData()[activityId] as ListItem.Card
        view.findViewById<TextView>(R.id.distanceText).text = activityData.distance
        view.findViewById<TextView>(R.id.timeText).text = activityData.time
        view.findViewById<TextView>(R.id.dateText).text = activityData.date
        view.findViewById<TextView>(R.id.userText).text = activityData.user
        toolbar.title = activityData.kindSport
    }
}