package com.example.home6android3.data.remote.aplservlces

import com.example.home6android3.data.remote.models.Photo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

private const val END_POINT = "photos"

interface PhotoApiService {

    @POST(END_POINT)
    fun addPhoto(
        @Body photo: Photo
    ) : Call<Photo>
}