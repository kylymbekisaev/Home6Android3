package com.example.home6android3.ui.fragments.insert

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home6android3.data.PhotoRepository
import com.example.home6android3.data.remote.models.Photo
import com.example.home6android3.ui.utils.UiState

class InsertViewModel : ViewModel() {

    private val photoRepository = PhotoRepository()

    private val _photoLiveData = MutableLiveData<UiState<Photo>>(UiState.Loading())
    val photoLiveData: LiveData<UiState<Photo>> = _photoLiveData

    fun addPhoto(photo: Photo) {
        photoRepository.addPhoto(
            photo = photo,
            onResponse = {
                photoRepository.insertPhoto(photo)
                _photoLiveData.value = UiState.Success(photo)
            },
            onFailure = { message, t ->
                Log.e("addPhoto", message, t)
                _photoLiveData.value = UiState.Error(message, t)
            }
        )
    }
}