package com.cyclone.newsagregator.network.sources

import com.cyclone.newsagregator.network.rss.RSS
import com.cyclone.newsagregator.network.rss.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface FourPDA: RSS {

    @GET("feed")
    override fun getFeed(): Call<RssFeed>
}