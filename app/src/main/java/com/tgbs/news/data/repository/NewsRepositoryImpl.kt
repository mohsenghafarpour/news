package com.tgbs.news.data.repository

import androidx.lifecycle.LiveData
import com.tgbs.news.data.db.NewsDao
import com.tgbs.news.data.pojo.*
import com.tgbs.news.network.Result
import com.tgbs.news.network.api.NewsEnApi
import com.tgbs.news.network.api.NewsFaApi
import com.tgbs.news.utils.combine
import com.tgbs.news.utils.safeApiCall

class NewsRepositoryImpl(
    private val newsApi: NewsFaApi,
    private val newsEnApi: NewsEnApi,
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun getNewsFaFromNetwork(): Result<NewsFa> = safeApiCall {
        val response = newsApi.getNews()
        response.channel?.details?.let { newsDao.upsertNewsFaDetail(it) }
        return@safeApiCall Result.Success(response)
    }

    override suspend fun getNewsEnFromNetwork(source: String, apiKey: String): Result<NewsEn> =
        safeApiCall {
            val response = newsEnApi.getNewsEn(source, apiKey)
            newsDao.upsertNewsEnDetail(response.articles)
            return@safeApiCall Result.Success(response)
        }

    override fun getNewsFa(): LiveData<List<Detail>> = newsDao.getNewsFaDetail()

    override fun getNewsEn(): LiveData<List<Article>> = newsDao.getNewsEnDetail()

    override suspend fun toggleFavoriteNews(news: News) {
        val isFavorite = news.isFavorite ?: false
        when (news) {
            is Article -> {
                if (isFavorite) newsDao.unFavoriteNewsEn(news.link)
                else newsDao.favoriteNewsEn(news.link)
            }
            is Detail -> {
                if (isFavorite) newsDao.unFavoriteNewsFa(news.guid)
                else newsDao.favoriteNewsFa(news.guid)
            }
        }
    }

    override fun getFavoriteNews() =
        combine(newsDao.getFavoriteNewsEn(), newsDao.getFavoriteNewsFa()) { news_en, news_fa ->
            val list = mutableListOf<News>()
            news_en?.let { list.addAll(it) }
            news_fa?.let { list.addAll(it) }
            return@combine list.toList()

        }

    override suspend fun findNewsById(id: String, newsType: NewsType): News? =
        when (newsType) {
            NewsType.ARTICLE -> (newsDao.findNewsEnById(id))
            NewsType.DETAIL -> (newsDao.findNewsFaById(id))
        }


}