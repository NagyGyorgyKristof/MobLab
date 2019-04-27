package com.example.moblabandroid.db.entities


inline fun <reified T> String.toRoomEnum(): T where T : Enum<T>, T : RoomEnum {
    return enumValues<T>().first { it.value == this }
}

interface RoomEnum {
    val value: String
}
