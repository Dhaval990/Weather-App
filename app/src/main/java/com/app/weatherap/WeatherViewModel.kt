package com.app.weatherap

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.weatherap.models.WeatherData
import kotlinx.coroutines.launch

class WeatherViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    private val livedata = MutableLiveData<WeatherData>()
    val test: LiveData<WeatherData>
        get() = livedata


    fun test(cityName: String) {
        viewModelScope.launch {
            livedata.value = repo.getWeatherDataByCity(cityName).body()
        }
    }
}