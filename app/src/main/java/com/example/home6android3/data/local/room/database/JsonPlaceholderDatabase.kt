package com.example.home6android3.data.local.room.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.home6android3.data.local.room.dao.PhotoDao
import com.example.home6android3.data.local.room.entity.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class JsonPlaceholderDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao
}