package com.tgbs.news.data.repository

import androidx.lifecycle.LiveData
import com.tgbs.news.data.pojo.*
import com.tgbs.news.network.Result

interface NewsRepository {

    suspend fun getNewsFaFromNetwork(): Result<NewsFa>

    suspend fun getNewsEnFromNetwork(source: String, apiKey: String): Result<NewsEn>

    fun getNewsFa(): LiveData<List<Detail>>

    fun getNewsEn(): LiveData<List<Article>>

    suspend fun toggleFavoriteNews(news: News)

    suspend fun findNewsById(id: String, newsType: NewsType): News?

    fun getFavoriteNews(): LiveData<List<News>>
}
