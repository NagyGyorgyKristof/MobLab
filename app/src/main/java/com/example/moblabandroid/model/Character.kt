package com.example.moblabandroid.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Character(

    /**
     */
    @SerializedName("id")
    var id: Long? = null,

    /**
     */
    @SerializedName("name")
    var name: String? = null,

    /**
     * character live status
     */
    @SerializedName("status")
    var status: StatusEnum? = null,

    /**
     */
    @SerializedName("species")
    var species: String? = null,

    /**
     */
    @SerializedName("type")
    var type: String? = null,

    /**
     * character's gender
     */
    @SerializedName("gender")
    var gender: GenderEnum? = null,

    /**
     */
    @SerializedName("origin")
    var origin: Origin? = null,

    /**
     */
    @SerializedName("location")
    var location: Location? = null,

    /**
     */
    @SerializedName("image")
    var image: String? = null,

    /**
     */
    @SerializedName("episode")
    var episode: List<String> = ArrayList(),

    /**
     */
    @SerializedName("url")
    var url: String? = null,

    /**
     */
    @SerializedName("created")
    var created: String? = null
)

enum class GenderEnum private constructor(private val value: String) {
    @SerializedName("Female")
    FEMALE("Female"),

    @SerializedName("Male")
    MALE("Male"),

    @SerializedName("Genderless")
    GENDERLESS("Genderless"),

    @SerializedName("unknown")
    UNKNOWN("unknown");

    override fun toString(): String {
        return value
    }
}

enum class StatusEnum private constructor(private val value: String) {
    @SerializedName("alive")
    ALIVE("alive"),

    @SerializedName("dead")
    DEAD("dead"),

    @SerializedName("unknown")
    UNKNOWN("unknown");

    override fun toString(): String {
        return value
    }
}