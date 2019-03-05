package org.zenika.core;

open class Pokemon (
        val id: Long,
        val name: String ,
        val baseExperience: String ,
        val height: Int ,
        val isDefault: Boolean ,
        val order: Int ,
        val weight: Int,
        val types: List<String>) {

    constructor(pokemon: Pokemon) : this(pokemon.id, pokemon.name, pokemon.baseExperience, pokemon.height,
            pokemon.isDefault, pokemon.order, pokemon.weight, pokemon.types)
};
