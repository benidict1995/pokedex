package com.benidict.model.dto

import com.google.gson.annotations.SerializedName
import java.util.Locale

data class PokemonDTO (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)