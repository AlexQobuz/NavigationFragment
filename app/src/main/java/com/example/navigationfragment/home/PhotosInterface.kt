package com.example.navigationfragment.home


import retrofit2.http.GET
import retrofit2.Call

interface PhotosInterface {

    @GET("photos")
    fun getAllPhotos(): Call<List<Photo>>

}