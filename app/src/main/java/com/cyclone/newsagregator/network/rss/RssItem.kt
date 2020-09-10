package com.cyclone.newsagregator.network.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class RssItem  (

    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String,

    @field:Element(name = "link")
    @param:Element(name = "link")
    var link: String
)
