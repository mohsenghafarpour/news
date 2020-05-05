package com.tgbs.news.di

import com.tgbs.news.network.api.NewsEnApi
import com.tgbs.news.network.api.NewsFaApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val restModule = module {
    factory<NewsFaApi> { get<Retrofit>(RetrofitXmlQualifier).create() }
    factory<NewsEnApi> { get<Retrofit>(RetrofitJsonQualifier).create() }
}