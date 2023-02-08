package com.example.navigationfragment.user

import retrofit2.Call
import retrofit2.http.GET

interface UsersInterface {

    @GET("users")
    fun getAllUsers(): Call<List<User>>

}