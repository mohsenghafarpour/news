package com.tgbs.news.network.api

import com.tgbs.news.data.News
import retrofit2.http.GET

interface NewsApi {

    @GET("rss/tp/10")
    suspend fun getNews(
    ): News

}