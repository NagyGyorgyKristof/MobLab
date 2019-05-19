package com.example.moblabandroid.network


import com.example.moblabandroid.model.BaseCharacterWithPagesX
import com.example.moblabandroid.model.CharacterX
import retrofit2.Call
import retrofit2.http.*


interface RnMApi {
    /**
     * get all characters
     *
     * @return Call<BaseCharacterWithPages>
    </BaseCharacterWithPages> */

    @GET("character")
    fun getAllChars(): Call<BaseCharacterWithPagesX>


    /**
     * Create a new characterItem
     *
     * @param body Character object that needs to be added to the server
     * @return Call<Void>
    </Void> */

    @POST("character")
    fun createNewChar(
        @Body body: CharacterX?
    ): Call<Void>


    /**
     * Find characterItem by ID
     * Returns a single characterItem
     * @param characterId ID of characterItem to return
     * @return Call<Character>
    </Character> */

    @GET("character/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Long?
    ): Call<CharacterX>


    /**
     * Update an existing characterItem
     *
     * @param characterId ID of char to update
     * @param body Character object that needs to be added to the server
     * @return Call<Void>
    </Void> */

    @PUT("character/{characterId}")
    fun updateChar(
        @Path("characterId") characterId: Long?, @Body body: CharacterX?
    ): Call<Void>


    /**
     * delete a characterItem
     *
     * @param characterId ID of char to update
     * @return Call<Void>
    </Void> */

    @DELETE("character/{characterId}")
    fun deletChar(
        @Path("characterId") characterId: Long?
    ): Call<Void>
}

