package com.example.moblabandroid.db.entities

import com.example.moblabandroid.model.StatusEnum

enum class RoomStatusEnum(override val value: String) : RoomEnum {
    ALIVE("alive"),

    DEAD("dead"),

    UNKNOWN("unknown");
}


fun RoomStatusEnum.toStatusEnum() = StatusEnum.values().find { it.value == value }

fun StatusEnum.toRoomStatusEnum() = RoomStatusEnum.values().find { it.value == value }