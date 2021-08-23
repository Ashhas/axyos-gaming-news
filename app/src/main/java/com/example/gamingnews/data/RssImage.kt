package com.example.gamingnews.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "image", strict = false)
data class RssImage constructor(
    @field:Element(name = "url", required = true)
    @param:Element(name = "url", required = true)
    val url: String = "",

    @field:Element(name = "title", required = true)
    @param:Element(name = "title", required = true)
    val title: String = "",

    @field:Element(name = "link", required = true)
    @param:Element(name = "link", required = true)
    val link: String = "",
)