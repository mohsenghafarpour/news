package com.tgbs.news.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import timber.log.Timber



private const val BaseXmlUrl = "https://www.khabaronline.ir/"
private const val BaseJsonUrl = "http://newsapi.org/v2/"

//http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=95a7a91b22f74929b6159a2a4ea22cee


object ApiQualifier : Qualifier
object LoggerQualifier : Qualifier
object RetrofitXmlQualifier : Qualifier
object RetrofitJsonQualifier : Qualifier

val networkModule = module {

    factory<Interceptor>(LoggerQualifier) {
        HttpLoggingInterceptor { log ->
            Timber.d(log)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<Retrofit>(RetrofitXmlQualifier) {
        Retrofit.Builder()
            .baseUrl(BaseXmlUrl)
            .client(get(ApiQualifier))
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    single<Retrofit>(RetrofitJsonQualifier) {
        Retrofit.Builder()
            .baseUrl(BaseJsonUrl)
            .client(get(ApiQualifier))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<OkHttpClient>(ApiQualifier) {
        OkHttpClient.Builder().apply {
            addInterceptor(get<Interceptor>(LoggerQualifier))
        }
            .build()
    }

}