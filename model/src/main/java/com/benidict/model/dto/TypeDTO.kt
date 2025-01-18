package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class TypeDTO (
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: PokemonDTO
)