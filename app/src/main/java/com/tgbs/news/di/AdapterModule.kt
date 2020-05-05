package com.tgbs.news.di

import com.tgbs.news.ui.NewsXmlAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { NewsXmlAdapter() }
}