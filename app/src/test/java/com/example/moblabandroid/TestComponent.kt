package com.example.moblabandroid

import com.example.moblabandroid.interactor.InteractorModule
import dagger.Component
import hu.autsoft.cardiolifestyle.data.db.RoomModule
import hu.bme.aut.android.kotifydemo.mock.MockNetworkModule
import hu.bme.aut.android.kotifydemo.test.DetailsTest
import hu.bme.aut.android.kotifydemo.test.MainTest
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class, RoomModule::class])
interface TestComponent : ApplicationComponent {
    fun inject(detailsTest: DetailsTest)
    fun inject(mainTest: MainTest)
}
