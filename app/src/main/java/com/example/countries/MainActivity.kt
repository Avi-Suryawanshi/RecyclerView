package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val countries = arrayOf(
        Country("IN","India","Delhi",R.drawable.ind),
       Country ("AUS","Austrolia","Delhi",R.drawable.aus),
        Country ("NZ","Newzland","Delhi",R.drawable.nz),
        Country ("SL","Sri lanka","Delhi",R.drawable.sl),
        Country ("USA","America","Delhi",R.drawable.usa),
        Country ("CA","Canada","Delhi",R.drawable.canada),
        Country ("CN","China","Delhi",R.drawable.china),
        Country ("PAK","Pakistan","Lahore",R.drawable.pak),
        Country ("AF","Afganistan","Karachi",R.drawable.afganistan),
        Country ("EN","England","Manchaster",R.drawable.eng),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryList = findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CountryAdapter().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        val showCountries = findViewById<Button>(R.id.country_button)
        showCountries.setOnClickListener {
            (countryList.adapter as CountryAdapter).countryData =countries
        }
    }
}