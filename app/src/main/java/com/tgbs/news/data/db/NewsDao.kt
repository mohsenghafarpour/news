package com.tgbs.news.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tgbs.news.data.pojo.Article
import com.tgbs.news.data.pojo.Detail

@Dao
interface NewsDao {

    /*xml news_fa*/

    @Query("SELECT * FROM news_fa")
    fun getNewsFaDetail(): LiveData<List<Detail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNewsFaDetail(details: List<Detail>)

    @Query("DELETE FROM news_fa")
    suspend fun clearNewsFa()

    /*json - news_en*/

    @Query("SELECT * FROM news_en")
    fun getNewsEnDetail(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNewsEnDetail(details: List<Article>)

    @Query("DELETE FROM news_en")
    suspend fun clearNewsEn()


}