package com.example.moblabandroid.ui.details

import com.example.moblabandroid.model.CharacterX

interface DetailsScreen {
    fun showNetworkError(message: String)

    fun showCharacter(characters: CharacterX?)
}