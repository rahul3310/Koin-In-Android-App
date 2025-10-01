package com.koinInAndroidApp.koinDI


import com.koinInAndroidApp.MainViewModel
import com.koinInAndroidApp.repository.ImageRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //Image Repository
    single {
        ImageRepository(get())
    }

    viewModel {
        MainViewModel(get())
    }

}