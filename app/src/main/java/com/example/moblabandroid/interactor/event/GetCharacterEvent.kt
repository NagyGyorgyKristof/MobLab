package com.example.moblabandroid.interactor.event

import com.example.moblabandroid.model.Result

data class GetCharacterEvent(
    var code: Int = 0,
    var characters: List<Result>? = null,
    var throwable: Throwable? = null
)
