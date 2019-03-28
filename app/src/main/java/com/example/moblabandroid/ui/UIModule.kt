package com.example.moblabandroid.ui

import android.content.Context
import com.example.moblabandroid.interactor.ApiInteractor
import com.example.moblabandroid.ui.details.DetailsPresenter
import com.example.moblabandroid.ui.mainlist.MainListPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, apiInteractor: ApiInteractor) = MainListPresenter(executor, apiInteractor)

    @Provides
    @Singleton
    fun artistsPresenter(executor : Executor, apiInteractor: ApiInteractor) = DetailsPresenter(executor, apiInteractor)


}