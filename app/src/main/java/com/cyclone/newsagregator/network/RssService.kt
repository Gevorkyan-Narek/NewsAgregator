package com.cyclone.newsagregator.network

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RssService {

    companion object {
        private val _FOURPDA = "https://4pda.ru/"
        private val _HABR = "https://habr.com/ru/rss/"
        private val _VC = "https://vc.ru/rss/"
        private val _YANDEX = "https://news.yandex.ru/"

        private var rss4PDA: FourPDA? = null
        private var rssHabr: Habr? = null
        private var rssVC: VC? = null
        private var rssYandex: Yandex? = null

        fun getRss4PDA(): FourPDA? {
            if(rss4PDA != null) return rss4PDA

            return connect(_FOURPDA).create(FourPDA::class.java)
        }

        fun getRssHabr(): Habr? {
            if(rssHabr != null) return rssHabr

            return connect(_HABR).create(Habr::class.java)
        }

        fun getRssVC(): VC? {
            if(rssHabr != null) return rssVC

            return connect(_VC).create(VC::class.java)
        }

        fun getRssYandex(): Yandex? {
            if(rssHabr != null) return rssYandex

            return connect(_YANDEX).create(Yandex::class.java)
        }

        private fun connect(url: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
        }
    }
}