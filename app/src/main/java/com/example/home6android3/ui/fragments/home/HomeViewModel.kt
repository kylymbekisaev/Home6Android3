package com.example.home6android3.ui.fragments.home

import androidx.lifecycle.ViewModel
import com.example.home6android3.data.PhotoRepository

class HomeViewModel : ViewModel() {

    private val photosRepository = PhotoRepository()

    fun getPhotos() = photosRepository.getPhotos()
}