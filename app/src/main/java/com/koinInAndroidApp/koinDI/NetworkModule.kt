package com.koinInAndroidApp.koinDI

import com.koinInAndroidApp.api.ApiService
import com.koinInAndroidApp.interceptor.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.thecatapi.com/"
val networkModule = module {

    //Api key interceptor

    single {
        ApiKeyInterceptor()
    }
    //Http logger
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    //Okhttp client
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<ApiKeyInterceptor>())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    //Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //ApiService
    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}