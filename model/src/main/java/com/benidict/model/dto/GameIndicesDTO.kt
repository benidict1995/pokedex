package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class GameIndicesDTO (
    @SerializedName("game_index")
    val gameIndex: Int,
    @SerializedName("version")
    val version: VersionDTO
)