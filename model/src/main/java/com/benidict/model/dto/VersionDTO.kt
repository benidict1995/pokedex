package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class VersionDTO (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)