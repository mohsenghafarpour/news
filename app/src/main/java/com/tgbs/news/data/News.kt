package com.tgbs.news.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.*

private const val TABLE_NAME = "news"

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

@Entity(tableName = TABLE_NAME)
@Root(name = "item", strict = false)
data class Detail @JvmOverloads constructor(
    @ColumnInfo(name = "title")
    @field:Path("title")
    @field:Text(required = false)
    @param:Path("title")
    @param:Text(required = false)
    val title: String? = null,

    @ColumnInfo(name = "description")
    @field:Path("description")
    @field:Text(required = false)
    @param:Path("description")
    @param:Text(required = false)
    val description: String? = null,

    @ColumnInfo(name = "enclosure")
    @field:Path("enclosure")
    @field:Text(required = false)
    @param:Path("enclosure")
    @param:Text(required = false)
    val imageUrl: String? = null,

    @ColumnInfo(name = "category")
    @field:Path("category")
    @field:Text(required = false)
    @param:Path("category")
    @param:Text(required = false)
    val category: String? = null,

    @ColumnInfo(name = "pubDate")
    @field:Path("pubDate")
    @field:Text(required = false)
    @param:Path("pubDate")
    @param:Text(required = false)
    val date: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "guid")
    @field:Element(name = "guid")
    @field:Text(required = false)
    @param:Element(name = "guid")
    @param:Text(required = false)
    val guid: String = ""
)