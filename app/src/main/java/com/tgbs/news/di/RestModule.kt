package com.tgbs.news.di

import com.tgbs.news.network.api.NewsApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val restModule = module {
    factory<NewsApi> { get<Retrofit>().create() }
}