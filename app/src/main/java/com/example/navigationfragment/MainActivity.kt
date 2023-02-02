package com.example.navigationfragment

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    // Je récupère BottomNavigationView
    // lateinit var bottomNav : BottomNavigationView

    lateinit var editCityName: EditText
    lateinit var btnSearch: Button
    lateinit var imageWeather: ImageView
    lateinit var tvTemperature: TextView
    lateinit var tvCityName: TextView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editCityName = findViewById(R.id.editCity)
        btnSearch = findViewById(R.id.btn_search)
        imageWeather = findViewById(R.id.image_weather)
        tvTemperature = findViewById(R.id.temperature)
        tvCityName = findViewById(R.id.city_name)

        btnSearch.setOnClickListener{
            val city = editCityName.text.toString()
            if (city.isEmpty()) {
                Toast.makeText(this, "City name can't be empty", Toast.LENGTH_LONG).show()
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
                val result = response.body()



                Picasso.get().load("htpps://openweathermap.org/img/w/${result?.weather!![0]?.icon}.png").into(imageWeather)

                tvTemperature.text = "${result?.main?.temp} °C"
                tvCityName.text = result.name
            }

            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                Toast.makeText(applicationContext, "Erreur serveur", Toast.LENGTH_LONG).show()
            }

        })
}

        /**loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }*/



    /**@RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkConnected(): Boolean {
        //1
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //2
        val activeNetwork = connectivityManager.activeNetwork
        //3
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //4
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }*/


    /**private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id., fragment)
        transaction.addToBackStack(HomeFragment().toString())
        transaction.commit()
    }*/
}