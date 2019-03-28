package com.example.moblabandroid.interactor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArtistsInteractor(rickAndMortyApi: RickAndMortyApi) = ApiInteractor(rickAndMortyApi)
}