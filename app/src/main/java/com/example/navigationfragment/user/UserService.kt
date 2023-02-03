package com.example.navigationfragment.user

import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("?results=5000")
    fun getUser(user: String): Call<User>

}
