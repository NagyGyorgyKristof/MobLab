package com.example.moblabandroid

import android.content.Context
import com.example.moblabandroid.interactor.ApiInteractor
import com.example.moblabandroid.ui.details.DetailsPresenter
import com.example.moblabandroid.ui.mainlist.MainListPresenter
import dagger.Module
import dagger.Provides
import hu.bme.aut.android.kotifydemo.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, apiInteractor: ApiInteractor) = MainListPresenter(executor, apiInteractor)

    @Provides
    @Singleton
    fun detailsPresenter(executor: Executor, apiInteractor: ApiInteractor) = DetailsPresenter(executor, apiInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}
