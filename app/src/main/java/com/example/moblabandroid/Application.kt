package com.example.moblabandroid

import android.app.Application
import com.example.moblabandroid.ui.UIModule
import dagger.internal.DaggerCollections

class Application : Application() {
    lateinit var injector: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}