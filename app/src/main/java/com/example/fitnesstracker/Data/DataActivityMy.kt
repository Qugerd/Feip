package com.example.fitnesstracker.Data

import com.example.fitnesstracker.ListItem
import org.joda.time.DateTime

class DataActivityMy {

    private val dateFormat = "dd.MM.YYYY"

    private val data = listOf<ListItem>(
        ListItem.Date(0, DateTime.now().toString(dateFormat)),
        ListItem.Card(1 , "", "Бег", "14.32 км","2 часа 30 мин", DateTime.now().toString(dateFormat)),
        ListItem.Date(2, DateTime.now().toString(dateFormat)),
        ListItem.Card(3 , "", "качели", "228 км", "6 часов", DateTime.now().toString(dateFormat))
    )

    fun getData() = data

    private fun getMaxId() = data.maxOf{it.id}
}