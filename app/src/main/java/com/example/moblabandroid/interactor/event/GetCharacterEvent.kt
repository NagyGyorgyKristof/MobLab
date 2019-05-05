package com.example.moblabandroid.interactor.event

import com.example.moblabandroid.model.CharacterX

data class GetCharacterEvent(
    var code: Int = 0,
    var characters: List<CharacterX>? = null,
    var throwable: Throwable? = null
)
