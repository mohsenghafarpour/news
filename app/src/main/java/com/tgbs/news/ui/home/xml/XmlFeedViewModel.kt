package com.tgbs.news.ui.home.xml

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tgbs.news.base.BaseViewModel
import com.tgbs.news.data.Detail
import com.tgbs.news.data.repository.NewsRepository
import com.tgbs.news.network.Result
import com.tgbs.news.utils.ktx.logD
import kotlinx.coroutines.launch

class XmlFeedViewModel(private val newsRepository: NewsRepository) : BaseViewModel() {

    private val _news = MutableLiveData<List<Detail>>()
    val news: LiveData<List<Detail>>
        get() = _news

    private fun getNewsFromNetwork() = viewModelScope.launch {
        when (val result = newsRepository.getNewsFromNetwork()) {
            is Result.Success -> _news.postValue(result.data.channel?.details)
            is Result.Error -> logD("error this part")
        }
    }

    init {
        getNewsFromNetwork()
    }

}