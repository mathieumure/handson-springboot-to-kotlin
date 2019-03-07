package org.zenika.core

open class Pokemon () {
    var id: Long? = null
    var name: String? = null
    var baseExperience: String? = null
    var height: Int? = null
    var isDefault: Boolean? = null
    var order: Int? = null
    var weight: Int? = null
    var types: List<String> = mutableListOf()

    constructor(pokemon: Pokemon): this() {
        this.apply {
            id = pokemon.id
            name = pokemon.name
            baseExperience = pokemon.baseExperience
            height = pokemon.height
            isDefault = pokemon.isDefault
            order = pokemon.order
            weight = pokemon.weight
            types = pokemon.types
        }
    }
}
