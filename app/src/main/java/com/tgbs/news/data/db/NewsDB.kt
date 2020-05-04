package com.tgbs.news.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tgbs.news.data.Detail


@Database(
    entities = [
        Detail::class
    ], version = 1, exportSchema = false
)

abstract class NewsDB : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}