package com.tgbs.news.data.repository

import com.tgbs.news.data.News
import com.tgbs.news.network.Result
import com.tgbs.news.network.api.NewsApi
import com.tgbs.news.utils.safeApiCall

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override suspend fun getNewsFromNetwork(): Result<News> = safeApiCall {
        val response = newsApi.getNews()
        return@safeApiCall Result.Success(response)
    }

}