package com.example.home6android3.data.remote.models

import com.example.home6android3.data.local.room.entity.PhotoEntity
import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
) {
    fun toEntity(): PhotoEntity {
        return PhotoEntity(
            albumId = albumId,
            id = id,
            title = title,
            url = url,
            thumbnailUrl = thumbnailUrl
        )
    }
}
