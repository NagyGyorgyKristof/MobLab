package com.example.moblabandroid.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "character")
data class RoomCharacter(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val status: RoomStatusEnum,
    val species: String,
    val type: String,
    val gender: RoomGenderEnum,
    val image: String
)