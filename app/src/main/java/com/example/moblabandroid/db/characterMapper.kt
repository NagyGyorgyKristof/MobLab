package com.example.moblabandroid.db

import com.example.moblabandroid.db.entities.RoomCharacter
import com.example.moblabandroid.model.Result


fun Result.toRoomModel(): RoomCharacter {
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

fun RoomCharacter.toResult(): Result {
    //TODO bajok lehetnek az enumokkal
    return Result(
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