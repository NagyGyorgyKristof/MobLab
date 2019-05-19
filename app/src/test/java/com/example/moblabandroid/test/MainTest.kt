package com.example.moblabandroid.test

import com.example.moblabandroid.model.CharacterX
import com.example.moblabandroid.testInjector
import com.example.moblabandroid.ui.mainlist.MainListPresenter
import com.example.moblabandroid.ui.mainlist.MainListScreen
import hu.bme.aut.android.kotifydemo.utils.argumentCaptor
import hu.bme.aut.android.kotifydemo.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainListPresenter
    private lateinit var mainScreen: MainListScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testGetAllCharacter() {
        mainPresenter.load()

        val list = argumentCaptor<MutableList<CharacterX>>()
        verify(mainScreen).showCharacters(list.capture())
        assert(list.value.size > 0)
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}