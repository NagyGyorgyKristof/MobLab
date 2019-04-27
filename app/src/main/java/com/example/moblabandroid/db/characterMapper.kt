package com.example.moblabandroid.db

import com.example.moblabandroid.db.entities.*
import com.example.moblabandroid.model.Character


fun Character.toRoomModel(): RoomCharacter {
    return RoomCharacter(
        //TODO lehet elszáll mert nincs itt id!!
        id = id!!,
        name = name ?: "",
        status = status?.toRoomStatusEnum()!!,
        species = species ?: "",
        type = type ?: "",
        gender = gender?.toRoomGenderEnum()!!,
        image = image ?: ""

    )
}

fun RoomCharacter.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status.toStatusEnum(),
        species = species,
        type = type,
        gender = gender.toGenderEnum(),
        origin = null,
        location = null,
        image = image,
        episode = emptyList(),
        created = ""
    )
}