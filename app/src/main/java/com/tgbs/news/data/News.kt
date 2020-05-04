package com.tgbs.news.data

import org.simpleframework.xml.*

@Root(name = "rss", strict = false)
data class News(
    @field:Element(name = "channel")
    @param:Element(name = "channel")
    val channel: Channel? = null
)

@Root(name = "channel", strict = false)
data class Channel @JvmOverloads constructor(
    @field:ElementList(entry = "item", inline = true)
    @param:ElementList(entry = "item", inline = true)
    val details: List<Detail>? = null
)

@Root(name = "item", strict = false)
data class Detail @JvmOverloads constructor(

    @field:Path("title")
    @field:Text(required = false)
    @param:Path("title")
    @param:Text(required = false)
    val title: String? = null,

    @field:Path("description")
    @field:Text(required = false)
    @param:Path("description")
    @param:Text(required = false)
    val description: String? = null,


    @field:Path("enclosure")
    @field:Text(required = false)
    @param:Path("enclosure")
    @param:Text(required = false)
    val imageUrl: String? = null,

    @field:Path("category")
    @field:Text(required = false)
    @param:Path("category")
    @param:Text(required = false)
    val category: String? = null,

    @field:Path("pubDate")
    @field:Text(required = false)
    @param:Path("pubDate")
    @param:Text(required = false)
    val date: String? = null,

    @field:Element(name = "guid")
    @param:Element(name = "guid")
    val guid: String? = null
)