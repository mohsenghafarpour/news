package com.tgbs.news.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.tgbs.news.data.db.NewsDB
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val DB_NAME = "application_db"


val dbModule = module {

    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(androidApplication())
    }


    single {
        Room.databaseBuilder(
            androidContext(),
            NewsDB::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    factory {
        get<NewsDB>().newsDao()
    }


}