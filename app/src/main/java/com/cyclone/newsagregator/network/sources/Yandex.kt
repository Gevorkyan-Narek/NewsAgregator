package com.cyclone.newsagregator.network.sources

import com.cyclone.newsagregator.network.rss.RSS
import com.cyclone.newsagregator.network.rss.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface Yandex: RSS {

    @GET("Samara/index.rss")
    override fun getFeed(): Call<RssFeed>

    @GET("cyber_sport.rss")
    fun getCyberSport(): Call<RssFeed>

    @GET("gadgets.rss")
    fun getGadgets(): Call<RssFeed>

    @GET("science.rss")
    fun getScience(): Call<RssFeed>

    @GET("computers.rss")
    fun getComputers(): Call<RssFeed>
}