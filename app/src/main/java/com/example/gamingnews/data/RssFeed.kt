package com.example.gamingnews.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
data class RssFeed constructor(
    @field:Element(name = "title", required = true)
    @param:Element(name = "title", required = true)
    @field:Path("channel")
    @param:Path("channel")
    val title: String = "",

    @field:Element(name = "description", required = true)
    @param:Element(name = "description", required = true)
    @field:Path("channel")
    @param:Path("channel")
    val description: String = "",

    @field:Element(name = "image", required = true)
    @param:Element(name = "image", required = true)
    @field:Path("channel")
    @param:Path("channel")
    val image: RssImage? = null,

    @field:Element(name = "generator", required = true)
    @param:Element(name = "generator", required = true)
    @field:Path("channel")
    @param:Path("channel")
    val generator: String = "",

    @field:Element(name = "lastBuildDate", required = true)
    @param:Element(name = "lastBuildDate", required = true)
    @field:Path("channel")
    @param:Path("channel")
    val lastBuildDate: String = "",

    @field:Element(name = "language", required = true)
    @param:Element(name = "language", required = true)
    @field:Path("channel")
    @param:Path("channel")
    val language: String = "",

    @field:ElementList(name = "item", inline = true)
    @param:ElementList(name = "item", inline = true)
    @field:Path("channel")
    @param:Path("channel")
    var itemList: List<RssItem>? = null
)