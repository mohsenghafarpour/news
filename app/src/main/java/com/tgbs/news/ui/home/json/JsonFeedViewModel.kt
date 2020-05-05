package com.tgbs.news.ui.home.json

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tgbs.news.base.BaseViewModel
import com.tgbs.news.data.pojo.Article
import com.tgbs.news.data.repository.NewsRepository
import kotlinx.coroutines.launch

private const val SOURCE = "techcrunch"
private const val API_KEY = "95a7a91b22f74929b6159a2a4ea22cee"

class JsonFeedViewModel(private val newsRepository: NewsRepository) : BaseViewModel() {

    val news: LiveData<List<Article>> = newsRepository.getNewsEn()

    private fun getNewsEnFromNetwork() = viewModelScope.launch {
        newsRepository.getNewsEnFromNetwork(SOURCE, API_KEY)
    }

    init {
        getNewsEnFromNetwork()
    }

}