package com.example.home6android3.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.home6android3.data.local.room.entity.PhotoEntity

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo_entity")
    fun getPhotos(): LiveData<List<PhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: PhotoEntity)
}