package com.cyclone.newsagregator.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Habr: RSS {

    @GET("news")
    override fun getFeed(): Call<RssFeed>

    @GET("news/page{page}/")
    override fun newPage(@Path("page") page: Int): Call<RssFeed>
}