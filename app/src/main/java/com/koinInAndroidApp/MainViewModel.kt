package com.koinInAndroidApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koinInAndroidApp.api.NetworkResult
import com.koinInAndroidApp.model.CatImages
import com.koinInAndroidApp.repository.ImageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ImageRepository) : ViewModel() {

    val imagesList = MutableStateFlow<List<CatImages>>(emptyList())

    fun loadCatImages() {
        viewModelScope.launch {
            when (val result = repository.getCatsImages(20)) {
                is NetworkResult.Success -> {
                    imagesList.emit(result.data ?: emptyList())
                }

                else -> {

                }
            }
        }

    }

}