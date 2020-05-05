package com.tgbs.news.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tgbs.news.data.pojo.Article
import com.tgbs.news.data.pojo.Detail


@Database(
    entities = [
        Detail::class,
        Article::class
    ], version = 1, exportSchema = false
)

abstract class NewsDB : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}