package com.example.moblabandroid.interactor.event

import com.example.moblabandroid.model.Character

data class GetCharacterEvent(
    var code: Int = 0,
    var characters: List<Character>? = null,
    var throwable: Throwable? = null
)
