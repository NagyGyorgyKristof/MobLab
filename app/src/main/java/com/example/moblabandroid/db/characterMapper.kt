package com.example.moblabandroid.db

import com.example.moblabandroid.db.entities.RoomCharacter
import com.example.moblabandroid.model.CharacterX


fun CharacterX.toRoomModel(): RoomCharacter {
    return RoomCharacter(
        //TODO lehet elszáll mert nincs itt id!!
        id = id.toLong(),
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        image = image

    )
}

fun RoomCharacter.toResult(): CharacterX {
    //TODO bajok lehetnek az enumokkal
    return CharacterX(
        id = id.toInt(),
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = null,
        location = null,
        image = image,
        episode = emptyList(),
        created = "",
        url = ""
    )
}