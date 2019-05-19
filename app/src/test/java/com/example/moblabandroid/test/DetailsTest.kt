package com.example.moblabandroid.test

import com.example.moblabandroid.model.CharacterX
import com.example.moblabandroid.testInjector
import com.example.moblabandroid.ui.details.DetailsPresenter
import com.example.moblabandroid.ui.details.DetailsScreen
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
class DetailsTest {
    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private lateinit var detailsScreen: DetailsScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        detailsScreen = mock()
        detailsPresenter.attachScreen(detailsScreen)
    }

    @Test
    fun testCharacterDetails() {
        detailsPresenter.load(1)

        val character = argumentCaptor<CharacterX>()
        verify(detailsScreen).showCharacter(character.capture())
        assert(character.value.status == "live")
    }

    @After
    fun tearDown() {
        detailsPresenter.detachScreen()
    }
}