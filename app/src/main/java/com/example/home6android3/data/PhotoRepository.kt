package com.example.home6android3.data

import com.example.home6android3.data.remote.RetrofitClient
import com.example.home6android3.data.local.room.RoomClient
import com.example.home6android3.data.remote.models.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository {

    private val photosApiService = RetrofitClient.photosApiService
    private val photoDao = RoomClient.RoomClient.database.photoDao()

    fun addPhoto(
        photo: Photo,
        onResponse: (photo: Photo) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        photosApiService.addPhoto(photo).enqueue(object : Callback<Photo> {
            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }

        })
    }

    fun getPhotos() = photoDao.getPhotos()

    fun insertPhoto(photo: Photo) {
        photoDao.insertPhoto(photo.toEntity())
    }
}