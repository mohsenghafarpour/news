package com.tgbs.news.ui.home.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tgbs.news.base.BaseViewModel
import com.tgbs.news.data.pojo.News
import com.tgbs.news.data.pojo.NewsType
import com.tgbs.news.data.repository.NewsRepository
import kotlinx.coroutines.launch

class DetailNewsViewModel(
    private val newsRepository: NewsRepository
) : BaseViewModel() {

    private var id: String? = null
    private var newsType: NewsType? = null

    fun onFavoriteClicked() = viewModelScope.launch {
        _news.value?.let {
            newsRepository.toggleFavoriteNews(it)
        }
        id?.let { id ->
            newsType?.let { newsType ->
                newsRepository.findNewsById(id, newsType)?.let {
                    _news.postValue(it)
                }
            }
        }

    }

    private val _news = MutableLiveData<News>()
    val news: LiveData<News>
        get() = _news

    fun loadUrl(id: String, newsType: NewsType) = viewModelScope.launch {
        this@DetailNewsViewModel.id = id
        this@DetailNewsViewModel.newsType = newsType
        newsRepository.findNewsById(id, newsType)?.let {
            _news.postValue(it)
        }

    }
}