package org.zenika.api.entity

import javax.persistence.*

@Entity
class Pokemon(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        @Column(name = "pokemonName") var name: String,
        var baseExperience: String,
        var height: Int,
        var isDefault: Boolean,
        @Column(name = "POKEMON_ORDER") var order: Int
        var weight: Int,
        var types: String) {

    fun toPokemon(): org.zenika.core.Pokemon = org.zenika.core.Pokemon().apply {
        id = this@Pokemon.id
        name = this@Pokemon.name
        baseExperience = this@Pokemon.baseExperience
        isDefault = this@Pokemon.isDefault
        height = this@Pokemon.height
        weight = this@Pokemon.weight
        order = this@Pokemon.order
        types = this@Pokemon.types.split(",")
    }
}