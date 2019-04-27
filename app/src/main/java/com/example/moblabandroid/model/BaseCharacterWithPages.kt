package com.example.moblabandroid.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class BaseCharacterWithPages(
    @SerializedName("info")
    var info: Info? = null,
    @SerializedName("result")
    var result: List<Character> = ArrayList()
)


