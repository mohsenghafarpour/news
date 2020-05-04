package com.tgbs.news.data.repository

import com.tgbs.news.data.News
import com.tgbs.news.network.Result

interface NewsRepository {

    suspend fun getNewsFromNetwork(): Result<News>
}