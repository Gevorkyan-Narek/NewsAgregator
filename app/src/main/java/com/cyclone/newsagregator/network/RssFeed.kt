package com.cyclone.newsagregator.network

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class RssFeed(

    @field:Element(name = "channel")
    @param:Element(name = "channel")
    var channel: RssChannel
)