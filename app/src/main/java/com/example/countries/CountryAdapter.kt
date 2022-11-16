package com.example.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var countryData = arrayOf<Country>()
        set(value) {
            field =value
            notifyDataSetChanged()
        }

    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view){
         val countryName:TextView = view.findViewById(R.id.country_name)
         val capitalName:TextView= view.findViewById(R.id.capital_name)
         val countryflag : ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
         val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return CountryViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        with(holder){
            countryflag.setImageResource(countryData[position].FlagID)
            countryName.text=countryData[position].name
            capitalName.text=countryData[position].capital
        }
    }

    override fun getItemCount(): Int {
        return countryData.size
    }

    override fun getItemId(position: Int): Long {
        return countryData[position].code.hashCode().toLong()
    }
}