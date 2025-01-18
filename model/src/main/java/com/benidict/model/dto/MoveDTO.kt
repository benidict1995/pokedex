package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class MoveDTO (
    @SerializedName("move")
    val move: PokemonDTO,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetailsDTO>
)