package com.tgbs.news.data.repository

import androidx.lifecycle.LiveData
import com.tgbs.news.data.pojo.Article
import com.tgbs.news.data.pojo.Detail
import com.tgbs.news.data.pojo.NewsEn
import com.tgbs.news.data.pojo.NewsFa
import com.tgbs.news.network.Result

interface NewsRepository {

    suspend fun getNewsFaFromNetwork(): Result<NewsFa>

    suspend fun getNewsEnFromNetwork(source: String, apiKey: String): Result<NewsEn>

    fun getNewsFa(): LiveData<List<Detail>>

    fun getNewsEn(): LiveData<List<Article>>
}