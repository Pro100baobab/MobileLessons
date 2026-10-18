package com.example.fragmentmanagerapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CountriesFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = CountriesAdapter(Countries.COUNTRIES,
            onItemClick = {
                // openDetails(it.id.toString())
                sharedViewModel.selectCountry(it)
                openDetails(sharedViewModel.selectedCountry.value?.id.toString())
            },
            onButtonClick = {
                sharedViewModel.selectCountry(it)
            }
        )
        recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    private fun openDetails(countryId: String){
        // val fragment = CountryDetailsFragment.newInstance(countryId)
        val fragment = CountryDetailsFragment()

        parentFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("country_details")
            .commit()
    }
}