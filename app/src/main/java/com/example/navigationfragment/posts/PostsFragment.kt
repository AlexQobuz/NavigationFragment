package com.example.navigationfragment.posts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.BASE_URL
import com.example.navigationfragment.Posts
import com.example.navigationfragment.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PostsFragment : Fragment() {

    lateinit var myAdapter: PostsAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerviewUsers: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerviewUsers = view.findViewById(R.id.recyclerview_posts)
        recyclerviewUsers.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerviewUsers.layoutManager = linearLayoutManager

        myAdapter = PostsAdapter(requireContext())
        recyclerviewUsers.adapter = myAdapter
        getMyData()

    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsInterface::class.java)

        val retrofitData = retrofitBuilder.getAllPosts()

        retrofitData.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                val responseBody = response.body()!!

                myAdapter.setItems(responseBody)
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Log.d("Activity main","Données non reçus ou problème d'affichage"+t.message )
            }

        })
    }

}