package com.example.fitnesstracker

sealed class ListItem(var id:Int){
    class Date(id: Int, val date: String): ListItem(id)
    class Card(id: Int,
               val user: String,
               val kindSport: String,
               val distance: String,
               val time: String,
               val date: String

    ): ListItem(id)
}