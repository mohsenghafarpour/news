package com.tgbs.news.ui.home.xml

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tgbs.news.base.BaseViewModel
import com.tgbs.news.data.pojo.Detail
import com.tgbs.news.data.repository.NewsRepository
import com.tgbs.news.ui.home.HomeFragmentDirections
import kotlinx.coroutines.launch

class XmlFeedViewModel(private val newsRepository: NewsRepository) : BaseViewModel() {

    val news: LiveData<List<Detail>> = newsRepository.getNewsFa()

    private fun getNewsFaFromNetwork() = viewModelScope.launch {
        newsRepository.getNewsFaFromNetwork()
    }

    init {
        getNewsFaFromNetwork()
    }

    fun goToDetailNews(link: String?) {
        navigateTo(HomeFragmentDirections.actionHomeToDetail(link))
    }

}