package com.tgbs.news.data.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

private const val TABLE_NAME = "news_en"

data class NewsEn(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResult: Int,
    @SerializedName("articles")
    val articles: List<Article>
)

@Entity(tableName = TABLE_NAME)
data class Article(
    @ColumnInfo(name = "author")
    @SerializedName("author")
    val author: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,
    @PrimaryKey
    @ColumnInfo(name = "url")
    @SerializedName("url")
    val url: String,
    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    val image: String,
    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt")
    val date: String,
    @ColumnInfo(name = "content")
    @SerializedName("content")
    val content: String
)