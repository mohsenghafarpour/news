package com.tgbs.news.data.repository

import androidx.lifecycle.LiveData
import com.tgbs.news.data.Detail
import com.tgbs.news.data.News
import com.tgbs.news.data.db.NewsDao
import com.tgbs.news.network.Result
import com.tgbs.news.network.api.NewsApi
import com.tgbs.news.utils.safeApiCall

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun getNewsFromNetwork(): Result<News> = safeApiCall {
        val response = newsApi.getNews()
        newsDao.clearNews()
        response.channel?.details?.let { newsDao.upsertNewsDetail(it) }
        return@safeApiCall Result.Success(response)
    }

    override fun getNews(): LiveData<List<Detail>> = newsDao.getNewsDetail()
}