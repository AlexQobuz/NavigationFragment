package com.example.navigationfragment.posts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.Post
import com.example.navigationfragment.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class PostsFragment : Fragment() {

    lateinit var myAdapter: PostsAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerviewPosts: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerviewPosts = view.findViewById(R.id.recyclerview_posts)
        recyclerviewPosts.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerviewPosts.layoutManager = linearLayoutManager

        myAdapter = PostsAdapter(requireContext())
        recyclerviewPosts.adapter = myAdapter
        getMyData()

    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsInterface::class.java)

        val retrofitData = retrofitBuilder.getAllPosts()

        retrofitData.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val responseBody = response.body()!!

                myAdapter.setItems(responseBody)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("Activity main","Les posts ne peuvent pas être afficher suite à un problème !"+t.message )
            }

        })
    }

}