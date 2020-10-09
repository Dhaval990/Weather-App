package com.app.weatherap

import com.app.weatherap.models.WeatherData
import com.app.weatherap.modules.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class Repo @Inject constructor(private val characterService: CharacterService) {
    suspend fun getWeatherDataByCity(cityName: String): Response<WeatherData> {
        return withContext(Dispatchers.IO) {
            characterService.getAllCharacters(cityName, "c0378e54fa53aecd829fd8bbb7f98ceb")

        }

    }
}