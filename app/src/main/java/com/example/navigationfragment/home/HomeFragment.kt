package com.example.navigationfragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.navigationfragment.R
import com.example.navigationfragment.WeatherResult
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var editCityName: EditText
    private lateinit var btnSearch: Button
    private lateinit var imageWeather: ImageView
    private lateinit var tvTemperature: TextView
    private lateinit var tvCityName: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editCityName.findViewById<EditText>(R.id.editCity)
        btnSearch.findViewById<Button>(R.id.btn_search)
        imageWeather.findViewById<ImageView>(R.id.imageWeather)
        tvTemperature.findViewById<TextView>(R.id.temperature)
        tvCityName.findViewById<TextView>(R.id.city_name)

        btnSearch.setOnClickListener{
            val city = editCityName.text.toString()
            if (city.isEmpty()) {
                Toast.makeText(requireContext(), "City name can't be empty", Toast.LENGTH_LONG).show()
            } else {
                getWeatherByCity(city)
            }
        }
    }

    fun getWeatherByCity(city: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/weather/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)
        val result = weatherService.getWeatherByCity(city)

        result.enqueue(object : Callback<WeatherResult> {
            override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    tvTemperature.text = "${result?.main?.temp} °C"
                    tvCityName.text = result?.name
                    Picasso.get()
                        .load("https://openweathermap.org/img/w/${result?.weather!![0]?.icon}.png")
                        .into(imageWeather)
                }
            }

            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                Toast.makeText(requireContext(), "Erreur serveur", Toast.LENGTH_LONG).show()
            }

        })
    }
}