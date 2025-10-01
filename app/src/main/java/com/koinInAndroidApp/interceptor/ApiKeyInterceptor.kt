package com.koinInAndroidApp.interceptor

import com.koinInAndroidApp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url  = request.url
        val newUrl = url.newBuilder()
            .addQueryParameter("api-key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(request.newBuilder().url(newUrl).build())
    }
}