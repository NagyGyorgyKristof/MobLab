package com.example.moblabandroid.interactor

import com.example.moblabandroid.db.CharacterDao
import com.example.moblabandroid.network.RnMApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideApiInteractor(rickAndMortyApi: RnMApi, characterDao: CharacterDao) =
        ApiInteractor(rickAndMortyApi, characterDao)
}