package com.tgbs.news.ui.home.xml

import androidx.lifecycle.viewModelScope
import com.tgbs.news.base.BaseViewModel
import com.tgbs.news.data.repository.NewsRepository
import kotlinx.coroutines.launch

class XmlFeedViewModel(private val newsRepository: NewsRepository) : BaseViewModel() {

    private fun getNewsFromNetwork() = viewModelScope.launch {
        newsRepository.getNewsFromNetwork()
    }

    init {
        getNewsFromNetwork()
    }

}