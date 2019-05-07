package com.example.moblabandroid.model

data class CharacterX(
    var created: String = "",
    var episode: List<String>,
    var gender: String = "",
    var id: Int = 0,
    var image: String = "",
    var location: LocationX? = null,
    var name: String = "",
    var origin: OriginX? = null,
    var species: String = "",
    var status: String = "",
    var type: String = "",
    var url: String = ""
)