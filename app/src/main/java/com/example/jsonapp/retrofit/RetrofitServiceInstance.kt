package com.example.jsonapp.retrofit

import com.example.jsonapp.data.Post
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {
    @GET("posts")
    fun getPosts() : Call<List<Post>>

}