package com.cyclone.newsagregator.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FourPDA: RSS {

    @GET("feed")
    override fun getFeed(): Call<RssFeed>
}