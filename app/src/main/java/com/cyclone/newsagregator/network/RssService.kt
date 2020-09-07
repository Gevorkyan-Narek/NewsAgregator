package com.cyclone.newsagregator.network

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RssService {

    companion object {
        private var rss = Retrofit.Builder()
            .baseUrl("https://4pda.ru/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(RSS::class.java)

        fun getApi4PDA(): RSS {
            return rss
        }
    }
}