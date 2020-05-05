package com.tgbs.news.data.repository

import androidx.lifecycle.LiveData
import com.tgbs.news.data.db.NewsDao
import com.tgbs.news.data.pojo.Article
import com.tgbs.news.data.pojo.Detail
import com.tgbs.news.data.pojo.NewsEn
import com.tgbs.news.data.pojo.NewsFa
import com.tgbs.news.network.Result
import com.tgbs.news.network.api.NewsEnApi
import com.tgbs.news.network.api.NewsFaApi
import com.tgbs.news.utils.safeApiCall

class NewsRepositoryImpl(
    private val newsApi: NewsFaApi,
    private val newsEnApi: NewsEnApi,
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun getNewsFaFromNetwork(): Result<NewsFa> = safeApiCall {
        val response = newsApi.getNews()
        newsDao.clearNewsFa()
        response.channel?.details?.let { newsDao.upsertNewsFaDetail(it) }
        return@safeApiCall Result.Success(response)
    }


    override suspend fun getNewsEnFromNetwork(source: String, apiKey: String): Result<NewsEn> =
        safeApiCall {
            val response = newsEnApi.getNewsEn(source, apiKey)
            newsDao.clearNewsEn()
            newsDao.upsertNewsEnDetail(response.articles)
            return@safeApiCall Result.Success(response)
        }

    override fun getNewsFa(): LiveData<List<Detail>> = newsDao.getNewsFaDetail()

    override fun getNewsEn(): LiveData<List<Article>> = newsDao.getNewsEnDetail()
}