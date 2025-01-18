package com.benidict.model.base

import com.google.gson.annotations.SerializedName

data class BaseResp<T>(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<T>
)