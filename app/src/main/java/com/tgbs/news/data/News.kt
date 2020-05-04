package com.tgbs.news.data

data class News(
    val title: String,
    val link: String,
    val description: String,
    val copyright: String,
    val lastBuildDate: String,
    val generator: String,
    val details: List<Detail>
)

data class Detail(
    val title: String,
    val link: String,
    val description: String,
    val enclosure : String,
    val pubDate : String
)