package com.example.fragmentmanagerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedViewModel = SharedViewModel()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(
                    R.id.fragment_container,
                    CountriesFragment()
                )
                .add(
                    R.id.fragment_container_details,
                    CountryDetailsFragment()
                )
                .commit()
        }
    }
}