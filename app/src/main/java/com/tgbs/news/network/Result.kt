package com.tgbs.news.network

import androidx.annotation.StringRes


sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(@StringRes val stringRes: Int, val errorCode: Int) : Result<Nothing>()

}