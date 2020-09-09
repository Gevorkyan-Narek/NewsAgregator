package com.cyclone.newsagregator.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface VC : RSS {

    @GET("tag/новости")
    override fun getFeed(): Call<RssFeed>

    @GET("tag/новости/page{page}/")
    override fun newPage(@Path("page") page: Int): Call<RssFeed>
}