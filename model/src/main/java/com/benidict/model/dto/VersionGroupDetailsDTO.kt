package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class VersionGroupDetailsDTO (
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    val moveLearnMethod: PokemonDTO,
    @SerializedName("version_group")
    val versionGroup: PokemonDTO
)