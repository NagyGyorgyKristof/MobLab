package com.example.moblabandroid

import com.example.moblabandroid.interactor.InteractorModule
import com.example.moblabandroid.network.NetworkModule
import com.example.moblabandroid.ui.UIModule
import com.example.moblabandroid.ui.details.CharacterDetailActivity
import com.example.moblabandroid.ui.mainlist.CharacterListActivity
import dagger.Component
import hu.autsoft.cardiolifestyle.data.db.RoomModule
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class, RoomModule::class])
interface ApplicationComponent {
    fun inject(characterListActivity: CharacterListActivity)
    fun inject(characterDetailActivity: CharacterDetailActivity)
}