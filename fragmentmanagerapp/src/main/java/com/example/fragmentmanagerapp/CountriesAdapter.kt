package com.example.fragmentmanagerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(
    private val countries: List<Country>,
    private val onItemClick: (Country) -> Unit,
    private val onButtonClick: (Country) -> Unit
): RecyclerView.Adapter<CountriesAdapter.CountriesHolder>() {

    class CountriesHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageCountry = view.findViewById<ImageView>(R.id.imageCountry)
        val nameCountry = view.findViewById<TextView>(R.id.nameCountry)
        val capitalCountry = view.findViewById<TextView>(R.id.capitalCountry)
        val buttonCountry = view.findViewById<Button>(R.id.buttonCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.country_item, parent, false
        )
        return CountriesHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountriesHolder, position: Int) {

        countries[position].run {
            holder.nameCountry.text = name
            holder.capitalCountry.text = capital
            holder.imageCountry.setImageResource(imageViewId)
        }

        holder.itemView.setOnClickListener{
            onItemClick(countries[position])
        }

        holder.buttonCountry.setOnClickListener{
            onButtonClick(countries[position])
        }
    }
}