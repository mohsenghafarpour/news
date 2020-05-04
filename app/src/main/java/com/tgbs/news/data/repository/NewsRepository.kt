package com.tgbs.news.data.repository

import androidx.lifecycle.LiveData
import com.tgbs.news.data.Detail
import com.tgbs.news.data.News
import com.tgbs.news.network.Result

interface NewsRepository {

    suspend fun getNewsFromNetwork(): Result<News>

    fun getNews(): LiveData<List<Detail>>
}