package com.cyclone.newsagregator.network

import retrofit2.Call
import retrofit2.http.GET

interface RSS {

    @GET("feed/")
    fun getFeed(): Call<RssFeed>
}