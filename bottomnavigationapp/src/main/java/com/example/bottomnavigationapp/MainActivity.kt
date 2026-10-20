package com.example.bottomnavigationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.bottomnavigationapp.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_info, R.id.navigation_profile).build()

        val navController = binding.navHostFragment.getFragment<NavHostFragment>().navController

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.bottomNavView, navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}