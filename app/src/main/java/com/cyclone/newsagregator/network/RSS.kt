package com.cyclone.newsagregator.network

import retrofit2.Call

interface RSS {

    fun getFeed(): Call<RssFeed>
    fun newPage(page: Int): Call<RssFeed>
}