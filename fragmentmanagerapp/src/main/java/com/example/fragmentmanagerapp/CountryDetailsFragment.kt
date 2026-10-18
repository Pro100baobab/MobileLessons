package com.example.fragmentmanagerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider

class CountryDetailsFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val countryId = requireArguments().getString(ARG_COUNTRY_ID, "0").toInt()
        // val currCountry = Countries.COUNTRIES[countryId]

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val currCountry = sharedViewModel.selectedCountry

        updateView(view, currCountry)

        sharedViewModel.selectedCountry.observe(viewLifecycleOwner) {
            updateView(view, currCountry)
        }
    }

    private fun updateView(view: View, currCountry: LiveData<Country>){
        view.run {
            currCountry.value?.imageViewId?.let { resId ->
                findViewById<ImageView>(R.id.imageCountry).setImageResource(resId)
            }

            findViewById<TextView>(R.id.textCountryName).text = currCountry.value?.name
            findViewById<TextView>(R.id.textCountryCapital).text = currCountry.value?.capital
            findViewById<TextView>(R.id.textCountryDescription).text = currCountry.value?.description
            findViewById<Button>(R.id.buttonBack).setOnClickListener{
                parentFragmentManager.popBackStack()
            }
        }
    }

    /*companion object {
        private const val ARG_COUNTRY_ID = "country_id"

        @JvmStatic
        fun newInstance(countryId: String) =
            CountryDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_COUNTRY_ID, countryId)
                }
            }
    }*/
}