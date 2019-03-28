package com.example.moblabandroid

import com.example.moblabandroid.interactor.InteractorModule
import com.example.moblabandroid.network.NetworkModule
import com.example.moblabandroid.ui.UIModule
import com.example.moblabandroid.ui.details.ItemDetailActivity
import com.example.moblabandroid.ui.mainlist.ItemListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface ApplicationComponent {
    fun inject(itemListActivity: ItemListActivity)
    fun inject(itemDetailActivity: ItemDetailActivity)
}