package com.example.home6android3.ui

import android.app.Application
import com.example.home6android3.data.local.preference.PreferencesHelper
import com.example.home6android3.data.local.room.RoomClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        RoomClient.RoomClient.init(this)
        PreferencesHelper.init(this)
    }
}