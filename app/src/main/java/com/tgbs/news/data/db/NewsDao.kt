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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsertNewsFaDetail(details: List<Detail>)

    @Query("UPDATE news_fa SET isFavorite=1 WHERE guid =:id")
    suspend fun favoriteNewsFa(id: String)

    @Query("UPDATE news_fa SET isFavorite=0 WHERE guid =:id")
    suspend fun unFavoriteNewsFa(id: String)

    @Query("SELECT * FROM news_fa WHERE isFavorite=1")
    fun getFavoriteNewsFa(): LiveData<List<Detail>>

    @Query("SELECT * FROM news_fa WHERE guid=:id")
    suspend fun findNewsFaById(id: String): Detail?


    /*json - news_en*/

    @Query("SELECT * FROM news_en")
    fun getNewsEnDetail(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsertNewsEnDetail(details: List<Article>)

    @Query("UPDATE news_en SET isFavorite=1 WHERE url =:id")
    suspend fun favoriteNewsEn(id: String)

    @Query("UPDATE news_en SET isFavorite=0 WHERE url =:id")
    suspend fun unFavoriteNewsEn(id: String)

    @Query("SELECT * FROM news_en WHERE isFavorite=1")
    fun getFavoriteNewsEn(): LiveData<List<Article>>

    @Query("SELECT * FROM news_en WHERE url=:id")
    suspend fun findNewsEnById(id: String): Article?


}