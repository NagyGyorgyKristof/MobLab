package com.example.moblabandroid.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.moblabandroid.db.entities.RoomCharacter

@Database(
    exportSchema = true,
    version = 1,
    entities = [
        RoomCharacter::class
    ]
)
@TypeConverters(
    CharacterConverter::class
)
abstract class RnMDataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}