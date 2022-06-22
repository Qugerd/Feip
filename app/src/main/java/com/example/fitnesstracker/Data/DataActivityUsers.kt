package com.example.fitnesstracker.Data

import com.example.fitnesstracker.ListItem

import org.joda.time.DateTime

class DataActivityUsers {

    private val dateFormat = "dd.MM.YYYY"

    private val data = listOf<ListItem>(
        ListItem.Date(0, DateTime.now().toString(dateFormat)),
        ListItem.Card(1 , "@он", "Бег", "322 км", "10 мин", DateTime.now().toString(dateFormat)),
        ListItem.Date(2, DateTime.now().toString(dateFormat)),
        ListItem.Card(3 , "@она", "серфинг", "1 км", "3 мин", DateTime.now().toString(dateFormat)),
        ListItem.Date(4, DateTime.now().toString(dateFormat)),
        ListItem.Card(5 , "@Путин", "флекс", "12 км", "23 мин", DateTime.now().toString(dateFormat))
    )

    fun getData() = data
}