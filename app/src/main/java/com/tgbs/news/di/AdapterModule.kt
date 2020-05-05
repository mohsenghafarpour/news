package com.tgbs.news.di

import com.tgbs.news.ui.FavoriteAdapter
import com.tgbs.news.ui.NewsEnAdapter
import com.tgbs.news.ui.NewsFaAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { NewsFaAdapter() }
    factory { NewsEnAdapter() }
    factory { FavoriteAdapter() }
}