package com.example.moblabandroid.interactor

import android.util.Log
import com.example.moblabandroid.interactor.event.GetCharacterEvent
import com.example.moblabandroid.network.RnMApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class ApiInteractor @Inject constructor(
    private var RnMApi: RnMApi
) {
    fun getAllCharacter() {
        val event = GetCharacterEvent()

        try {
            val characterQueryCall = RnMApi.getAllChars()

            val response = characterQueryCall.execute()
            Log.d("getAllCharacter Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("CharacterX code is not 200: ${response.code()}")
            }
            event.code = response.code()
            event.characters = response.body()?.results
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getCharacterById(characterId: Long) {
        val event = GetCharacterEvent()

        try {
            val characterQueryCall = RnMApi.getCharacterById(characterId)

            val response = characterQueryCall.execute()
            Log.d("getAllCharacter Reponse", response.body().toString())
            if (response.code() != 200 && response.code() != 404) {
                throw Exception("CharacterX code is not 200")
            }
            event.code = response.code()
            event.characters = listOf(response.body()!!)
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

}