package com.example.fitnesstracker.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.ListItem
import com.example.fitnesstracker.R
import com.example.fitnesstracker.Details.DetailsMy
import com.example.fitnesstracker.Details.DetailsUsers

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val DATE_VIEW_TYPE = 1
        private const val CARD_VIEW_TYPE = 2
    }

    private val data: MutableList<ListItem> = mutableListOf()

    override fun getItemViewType(position: Int): Int = when(data[position]) {
        is ListItem.Date -> DATE_VIEW_TYPE
        is ListItem.Card -> CARD_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == DATE_VIEW_TYPE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_date, parent, false)
            DateViewHolder(view)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card, parent, false)
            val text = view.findViewById<TextView>(R.id.userText)
            view.setOnClickListener {
                if(text.text == ""){
                    findNavController(view).navigate(R.id.action_fragmentSwitcher_to_detailsMy,
                        bundleOf(DetailsMy.KEY_NAME to view.id))
                }else{
                    findNavController(view).navigate(R.id.action_fragmentSwitcher_to_detailsUsers,
                        bundleOf(DetailsUsers.KEY_NAME to view.id))
                }
            }
            CardViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = data[position]){
            is ListItem.Date -> (holder as DateViewHolder).bind(item)
            is ListItem.Card -> (holder as CardViewHolder).bind(item, position)
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(data: List<ListItem>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class DateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val dateText = itemView.findViewById<TextView>(R.id.dateText)

        fun bind (date: ListItem.Date){
            dateText.text = date.date
        }
    }

    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val distanceText = itemView.findViewById<TextView>(R.id.distanceText)
        private val userText = itemView.findViewById<TextView>(R.id.userText)
        private val timeText = itemView.findViewById<TextView>(R.id.timeText)
        private val movingByText = itemView.findViewById<TextView>(R.id.movingByText)
        private val dateText = itemView.findViewById<TextView>(R.id.dateText)

        fun bind (card: ListItem.Card, position: Int){
            itemView.id = position

            distanceText.text = card.distance
            userText.text = card.user
            timeText.text = card.time
            movingByText.text = card.kindSport
            dateText.text = card.date
        }
    }
}