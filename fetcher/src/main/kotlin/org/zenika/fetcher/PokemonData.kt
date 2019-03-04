package org.zenika.fetcher;

import com.fasterxml.jackson.annotation.JsonProperty;

data class PokemonData(
    var id: Long,
    var name: String,
    @JsonProperty("base_experience")
    var baseExperience: String,
    var height: Int,
    @JsonProperty("is_default")
    var isDefault: Boolean,
    var order: Int,
    var weight: Int,
    var types: List<Type>)
