package com.cyclone.newsagregator.network.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class RssChannel (

    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String,

    @field:ElementList(name = "item", inline = true)
    @param:ElementList(name = "item", inline = true)
    var item: MutableList<RssItem>
)
