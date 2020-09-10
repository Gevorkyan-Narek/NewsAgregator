package com.cyclone.newsagregator.network.sources

import com.cyclone.newsagregator.network.rss.RSS
import com.cyclone.newsagregator.network.rss.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface VC : RSS {

    @GET("tag/новости")
    override fun getFeed(): Call<RssFeed>
}