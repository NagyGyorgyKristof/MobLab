package com.example.moblabandroid.model

import com.google.gson.annotations.SerializedName

enum class GenderEnum(val value: String) {
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

enum class StatusEnum(val value: String) {
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