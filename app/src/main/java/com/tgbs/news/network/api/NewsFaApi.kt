package com.tgbs.news.network.api

import com.tgbs.news.data.pojo.NewsFa
import retrofit2.http.GET

interface NewsFaApi {

    @GET("rss/tp/10")
    suspend fun getNews(
    ): NewsFa

}