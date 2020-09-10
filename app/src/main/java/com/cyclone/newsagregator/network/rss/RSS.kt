package com.cyclone.newsagregator.network.rss

import retrofit2.Call

interface RSS {

    fun getFeed(): Call<RssFeed>
    fun newPage(page: Int): Call<RssFeed>
}