package com.example.navigationfragment.home

import com.example.navigationfragment.Posts
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    /**companion object {
        const val API_KEY = "52cc828fec74287f7eb123ad478242b3"
    }*/

    @GET("posts")
    fun getAllPosts(): Call<List<Posts>>

}