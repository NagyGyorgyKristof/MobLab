package com.example.moblabandroid.ui.mainlist

import com.example.moblabandroid.model.CharacterX

interface MainListScreen {
    fun showNetworkError(message: String)

    fun showCharacters(characters: List<CharacterX>)
}