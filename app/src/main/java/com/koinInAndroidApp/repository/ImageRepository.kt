package com.koinInAndroidApp.repository

import com.koinInAndroidApp.api.ApiService
import com.koinInAndroidApp.api.NetworkResult
import com.koinInAndroidApp.api.safeApiCall
import com.koinInAndroidApp.model.CatImages

class ImageRepository(
    private val apiService: ApiService
) {
    suspend fun getCatsImages(limit: Int): NetworkResult<List<CatImages>> = safeApiCall {
        apiService.getCatsImagesList(limit)
    }
}