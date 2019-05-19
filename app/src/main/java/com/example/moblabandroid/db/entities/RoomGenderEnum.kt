package com.example.moblabandroid.db.entities

import com.example.moblabandroid.model.GenderEnum

enum class RoomGenderEnum(override val value: String) : RoomEnum {
    FEMALE("Female"),

    MALE("Male"),

    GENDERLESS("Genderless"),

    UNKNOWN("unknown");
}

fun RoomGenderEnum.toGenderEnum() = GenderEnum.values().find { it.value == value }

fun GenderEnum.toRoomGenderEnum() = RoomGenderEnum.values().find { it.value == value }
