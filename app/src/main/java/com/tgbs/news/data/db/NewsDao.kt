package com.tgbs.news.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tgbs.news.data.Detail

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getNewsDetail(): LiveData<List<Detail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNewsDetail(details: List<Detail>)

    @Query("DELETE FROM news")
    suspend fun clearNews()

}