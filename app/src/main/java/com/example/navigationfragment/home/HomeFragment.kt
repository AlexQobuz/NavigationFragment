package com.example.navigationfragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.R
import com.example.navigationfragment.user.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class HomeFragment : Fragment() {

    lateinit var myAdapter: PhotosAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview_photos)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager

        myAdapter = PhotosAdapter(requireContext())
        recyclerView.adapter = myAdapter
        getphotos()

    }

    private fun getphotos() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotosInterface::class.java)

        val retrofitData = retrofitBuilder.getAllPhotos()

        retrofitData.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val responseBody = response.body()!!

                myAdapter.setItems(responseBody)
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d("Home Fragment", "Les posts ne peuvent pas être afficher suite à un problème !"+t.message )
            }

        })
    }

}