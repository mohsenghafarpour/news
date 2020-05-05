package com.tgbs.news.network.api

import com.tgbs.news.data.pojo.NewsEn
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsEnApi {

    @GET("top-headlines")
    suspend fun getNewsEn(
        @Query("sources") sources: String ,
        @Query("apiKey") apiKey: String
    ): NewsEn

}