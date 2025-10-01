package com.koinInAndroidApp.api

import com.koinInAndroidApp.model.CatImages
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/images/search")
    suspend fun getCatsImagesList(@Query("limit") limit: Int): Response<List<CatImages>>


}