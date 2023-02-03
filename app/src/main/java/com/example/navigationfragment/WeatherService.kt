package com.example.navigationfragment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        const val API_KEY = "52cc828fec74287f7eb123ad478242b3"
    }

    @GET("?units=metric&appid=$API_KEY")
    fun getWeatherByCity(@Query("q")city: String): Call<WeatherResult>

}