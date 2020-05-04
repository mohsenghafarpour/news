package com.tgbs.news.utils

import com.tgbs.news.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.tgbs.news.network.Result
import com.tgbs.news.utils.ktx.logE

suspend fun <T : Any> safeApiCall(
    call: suspend () -> Result<T>
): Result<T> {
    return withContext(Dispatchers.Main) {
        try {
            withContext(Dispatchers.IO) {
                call()
            }
        } catch (e: Exception) {
            logE(e)
            Result.Error(R.string.app_name, 0)
        }
    }
}
