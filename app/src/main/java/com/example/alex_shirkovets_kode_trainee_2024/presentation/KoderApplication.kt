package com.example.alex_shirkovets_kode_trainee_2024.presentation

import android.app.Application
import com.example.alex_shirkovets_kode_trainee_2024.data.AppContainer
import com.example.alex_shirkovets_kode_trainee_2024.data.DefaultAppContainer

class KoderApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}