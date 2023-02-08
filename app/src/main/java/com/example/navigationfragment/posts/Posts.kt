package com.example.navigationfragment

interface PostsItems
data class Post(
    val body: String,
    var id: Int,
    var title: String,
    var userIdInPost: Int
):PostsItems


data class Mail(
    val body: String,
    var id: Int,
    var title: String,
    var userIdInPost: Int
):PostsItems