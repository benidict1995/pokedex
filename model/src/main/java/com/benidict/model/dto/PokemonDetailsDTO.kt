package com.benidict.model.dto

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDTO (
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("weight") val weight: Int? = 0,
    @SerializedName("height") val height: Int? = 0,
    @SerializedName("base_experience") val baseExperience: Int? = 0,
    @SerializedName("is_default") val isDefault: Boolean? = false,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String? = "",
    @SerializedName("abilities") val abilities: List<AbilityDTO>?= emptyList(),
    @SerializedName("cries") val cries: CriesDTO?= null,
    @SerializedName("name") val name: String?= null,
    @SerializedName("forms") val forms: List<PokemonDTO>?= emptyList(),
    @SerializedName("game_indices") val gameIndices: List<GameIndicesDTO>?= emptyList(),
    @SerializedName("moves") val moves: List<MoveDTO>?= emptyList(),
    @SerializedName("species") val species: PokemonDTO?= null,
    @SerializedName("stats") val stats: List<StatDTO>?= emptyList(),
    @SerializedName("types") val types: List<TypeDTO>?= emptyList(),
    @SerializedName("sprites") val sprites: SpritesDTO?= null
)