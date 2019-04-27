package com.example.moblabandroid.db

import android.arch.persistence.room.TypeConverter
import com.example.moblabandroid.db.entities.RoomGenderEnum
import com.example.moblabandroid.db.entities.RoomStatusEnum
import com.example.moblabandroid.db.entities.toRoomEnum

class CharacterConverter {

    @TypeConverter
    fun stringToRoomGenderEnum(value: String?): RoomGenderEnum? {
        return value?.toRoomEnum()
    }

    @TypeConverter
    fun roomRenderEnumToString(enumValue: RoomGenderEnum?): String? {
        return enumValue?.value
    }

    @TypeConverter
    fun stringToRoomStatusEnum(value: String?): RoomStatusEnum? {
        return value?.toRoomEnum()
    }

    @TypeConverter
    fun roomStatusEnumToString(enumValue: RoomStatusEnum?): String? {
        return enumValue?.value
    }
}