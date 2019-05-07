package com.example.moblabandroid.interactor

import com.example.moblabandroid.network.RnMApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideApiInteractor(rickAndMortyApi: RnMApi) =
        ApiInteractor(rickAndMortyApi)
}