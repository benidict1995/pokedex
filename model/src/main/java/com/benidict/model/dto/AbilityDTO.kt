package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class AbilityDTO (
    @SerializedName("ability") val ability: PokemonDTO,
    @SerializedName("is_hidden") val isHidden: Boolean,
    @SerializedName("slot") val slot: Int
)