package com.tgbs.news.di

import com.tgbs.news.ui.favorite.FavoriteViewModel
import com.tgbs.news.ui.home.HomeViewModel
import com.tgbs.news.ui.home.detail.DetailNewsViewModel
import com.tgbs.news.ui.home.json.JsonFeedViewModel
import com.tgbs.news.ui.home.xml.XmlFeedViewModel
import com.tgbs.news.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { FavoriteViewModel(get()) }
    viewModel { JsonFeedViewModel(get()) }
    viewModel { XmlFeedViewModel(get()) }
    viewModel { DetailNewsViewModel() }
}