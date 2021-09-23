package com.example.gamingnews.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class RssItem constructor(
    @field:Element(name = "title", required = true)
    @param:Element(name = "title", required = true)
    val itemTitle: String = "",

    @field:Element(name = "description", required = true)
    @param:Element(name = "description", required = true)
    val itemDescription: String = "",

    @field:Element(name = "pubDate", required = true)
    @param:Element(name = "pubDate", required = true)
    val itemPubDate: String = "",

    @field:Element(name = "link", required = true)
    @param:Element(name = "link", required = true)
    val itemLink: String = ""
)