package com.tgbs.news.di

import com.tgbs.news.data.repository.NewsRepository
import com.tgbs.news.data.repository.NewsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(get(),get()) }
}