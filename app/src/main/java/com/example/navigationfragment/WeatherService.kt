package com.example.navigationfragment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        const val API_KEY = "87a83b9b394f231c0554a33b02a4bf76"
    }

    @GET("?units=metric&appid=$API_KEY")
    fun getWeatherByCity(@Query("q")city: String): Call<WeatherResult>

}