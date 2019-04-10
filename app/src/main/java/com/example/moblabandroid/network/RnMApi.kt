package com.example.moblabandroid.network


import com.example.moblabandroid.model.BaseCharacterWithPages
import com.example.moblabandroid.model.Character
import retrofit2.Call
import retrofit2.http.*


interface RnMApi {
    /**
     * get all characters
     *
     * @return Call<BaseCharacterWithPages>
    </BaseCharacterWithPages> */

    @GET("character")
    fun getAllChars(): Call<BaseCharacterWithPages>


    /**
     * Create a new character
     *
     * @param body Character object that needs to be added to the server
     * @return Call<Void>
    </Void> */

    @POST("character")
    fun createNewChar(
        @Body body: Character?
    ): Call<Void>


    /**
     * Find character by ID
     * Returns a single character
     * @param characterId ID of character to return
     * @return Call<Character>
    </Character> */

    @GET("character/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Long?
    ): Call<Character>


    /**
     * Update an existing character
     *
     * @param characterId ID of char to update
     * @param body Character object that needs to be added to the server
     * @return Call<Void>
    </Void> */

    @PUT("character/{characterId}")
    fun updateChar(
        @Path("characterId") characterId: Long?, @Body body: Character?
    ): Call<Void>


    /**
     * delete a character
     *
     * @param characterId ID of char to update
     * @return Call<Void>
    </Void> */

    @DELETE("character/{characterId}")
    fun deletChar(
        @Path("characterId") characterId: Long?
    ): Call<Void>


}

