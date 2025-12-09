package com.koinInAndroidApp

import android.app.Application
import com.koinInAndroidApp.koinDI.appModule
import com.koinInAndroidApp.koinDI.networkModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //To start Koin
        startKoin {
            modules(networkModule, appModule)
        }
    }
}