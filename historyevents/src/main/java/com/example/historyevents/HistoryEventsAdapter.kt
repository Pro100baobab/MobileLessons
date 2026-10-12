package com.example.historyevents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class HistoryEventsAdapter(val events: List<HistoryEvent>):
    RecyclerView.Adapter<HistoryEventsAdapter.EventHolder>() {

    class EventHolder(view: View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.eventTitle)
        val description: TextView = view.findViewById(R.id.eventDescription)
        val imageDrawable: ImageView = view.findViewById(R.id.eventImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_event_item, parent, false)
        return EventHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        events[position].run {
            holder.title.setText(title)
            holder.description.setText(description)
            holder.imageDrawable.load(image)
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }
}