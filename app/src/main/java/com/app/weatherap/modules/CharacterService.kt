package com.app.weatherap.modules

import com.app.weatherap.models.WeatherData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("forecast/")
    suspend fun getAllCharacters(
        @Query("q", encoded = false) cityName: String,
        @Query("appid", encoded = false) appID: String
    ): Response<WeatherData>
}