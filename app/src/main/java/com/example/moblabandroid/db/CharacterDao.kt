package com.example.moblabandroid.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.moblabandroid.db.entities.RoomCharacter

@Dao
abstract class CharacterDao {
    //region Get
    @Query("SELECT * FROM character")
    abstract fun getAllCharacters(): List<RoomCharacter>

    @Query("SELECT * FROM character WHERE id = :characterID")
    abstract fun getCharacterById(characterID: Long): RoomCharacter
    //endregion

    //region Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCharacter(challengeBadge: RoomCharacter)
    //endregion

    //region Delete
    @Query("DELETE FROM character")
    abstract fun deleteAllChallenges()

    @Query("DELETE FROM character WHERE id = :id")
    abstract fun deleteChallenge(id: Long)
    //endregion
}