package com.tgbs.news.ui.favorite

import androidx.lifecycle.viewModelScope
import com.tgbs.news.base.BaseViewModel
import com.tgbs.news.data.pojo.Article
import com.tgbs.news.data.pojo.Detail
import com.tgbs.news.data.pojo.News
import com.tgbs.news.data.pojo.NewsType
import com.tgbs.news.data.repository.NewsRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(private val newsRepository: NewsRepository) : BaseViewModel() {

    val favoriteNews = newsRepository.getFavoriteNews()

    fun goToDetailNews(news: News?) {
        val (id, newsType) = when (news) {
            is Article -> news.link to NewsType.ARTICLE
            is Detail -> news.guid to NewsType.DETAIL
            else -> null to null
        }
        if (id == null || newsType == null) return
        navigateTo(FavoriteFragmentDirections.actionFavoriteToDetail(id, newsType))
    }

    fun onFavoriteClicked(news: News) = viewModelScope.launch {
        newsRepository.toggleFavoriteNews(news)
    }

}