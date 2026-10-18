package com.example.fragmentmanagerapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val _country: MutableLiveData<Country> = MutableLiveData()
    val selectedCountry: LiveData<Country> = _country

    fun selectCountry(country: Country) {
        _country.value = country
    }
}