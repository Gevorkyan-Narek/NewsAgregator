package com.cyclone.newsagregator.network

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RssService {

    companion object {
        private val FOURPDA = "https://4pda.ru/"
        private val HABR = "https://habr.com/ru/rss/"

        private var rss4PDA: FourPDA? = null
        private var rssHabr: Habr? = null

        fun getRss4PDA(): FourPDA? {
            if(rss4PDA != null) return rss4PDA

            return connect(FOURPDA).create(FourPDA::class.java)
        }

        fun getRssHabr(): Habr? {
            if(rssHabr != null) return rssHabr

            return connect(HABR).create(Habr::class.java)
        }

        private fun connect(url: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
        }
    }
}