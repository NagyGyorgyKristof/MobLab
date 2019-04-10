package com.example.moblabandroid.model

import com.google.gson.annotations.SerializedName


data class Info(
    /**
     */
    @SerializedName("count")
    var count: Long? = null,

    /**
     */
    @SerializedName("pages")
    var pages: Long? = null,

    /**
     */
    @SerializedName("next")
    var next: String? = null,

    /**
     */
    @SerializedName("prev")
    var prev: String? = null,

    /**
     */
    @SerializedName("complete")
    var complete: Boolean? = false
)
