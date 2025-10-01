package com.koinInAndroidApp.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T : Any> safeApiCall(
    call: suspend () -> Response<T>
): NetworkResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    NetworkResult.Success(body)
                } ?: NetworkResult.Error("Response body is null", response.code())
            } else {
                NetworkResult.Error(errorCode = 400, data = null, errorMessage = "API failure")
            }

        } catch (e: Exception) {
            NetworkResult.Error(
                errorCode = 520,
                data = null,
                errorMessage = "There is an exception api call"
            )
        }
    }

}