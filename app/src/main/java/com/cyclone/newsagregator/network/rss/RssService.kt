package com.cyclone.newsagregator.network.rss

import com.cyclone.newsagregator.links
import com.cyclone.newsagregator.network.sources.FourPDA
import com.cyclone.newsagregator.network.sources.Habr
import com.cyclone.newsagregator.network.sources.VC
import com.cyclone.newsagregator.network.sources.Yandex
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RssService {

    companion object {

        private var rss4PDA: FourPDA? = null
        private var rssHabr: Habr? = null
        private var rssVC: VC? = null
        private var rssYandex: Yandex? = null

        fun getRss4PDA(): FourPDA? {
            if (rss4PDA != null) return rss4PDA

            return connect(links[0].href).create(FourPDA::class.java)
        }

        fun getRssHabr(): Habr? {
            if (rssHabr != null) return rssHabr

            return connect(links[1].href).create(Habr::class.java)
        }

        fun getRssVC(): VC? {
            if (rssHabr != null) return rssVC

            return connect(links[2].href).create(VC::class.java)
        }

        fun getRssYandex(): Yandex? {
            if (rssHabr != null) return rssYandex

            return connect(links[3].href).create(Yandex::class.java)
        }

        private fun connect(url: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
        }
    }
}