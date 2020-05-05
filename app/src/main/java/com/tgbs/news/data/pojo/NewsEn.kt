package com.tgbs.news.data.pojo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

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
@Parcelize
data class Article(
    @ColumnInfo(name = "author")
    @SerializedName("author")
    val author: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    override val title: String,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    override val description: String,
    @PrimaryKey
    @ColumnInfo(name = "url")
    @SerializedName("url")
    override val link: String,
    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    val image: String,
    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt")
    override val date: String,
    @ColumnInfo(name = "content")
    @SerializedName("content")
    val content: String,
    @ColumnInfo(name = "isFavorite")
    override val isFavorite: Boolean?
) : Parcelable, News