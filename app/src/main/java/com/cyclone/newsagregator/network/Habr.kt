package com.cyclone.newsagregator.network

import retrofit2.Call
import retrofit2.http.GET

interface Habr {

    @GET("news/")
    fun getNews(): Call<RssFeed>
}