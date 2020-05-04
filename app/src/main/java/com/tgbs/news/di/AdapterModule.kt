package com.tgbs.news.di

import com.tgbs.news.ui.home.xml.XmlFeedAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { XmlFeedAdapter() }
}