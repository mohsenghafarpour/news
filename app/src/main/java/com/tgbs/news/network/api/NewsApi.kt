package com.tgbs.news.network.api

import com.tgbs.news.data.News
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApi {

    @GET
    suspend fun getNews(
        @Url url: String = "rss/tp/1"
    ): News

}