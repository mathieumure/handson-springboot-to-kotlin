package org.zenika.api.entity

import javax.persistence.*

@Entity
class Pokemon(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        @Column(name = "pokemonName") var name: String,
        var baseExperience: String,
        var height: Int,
        var isDefault: Boolean,
        @Column(name = "POKEMON_ORDER") var order: Int,
        var weight: Int,
        var types: String) {

    fun toPokemon(): org.zenika.core.Pokemon {
        val pokemon = org.zenika.core.Pokemon()
        pokemon.id = this.id
        pokemon.name = this.name
        pokemon.baseExperience = this.baseExperience
        pokemon.isDefault = this.isDefault
        pokemon.height = this.height
        pokemon.weight = this.weight
        pokemon.order = this.order
        pokemon.types = this.types.split(",")
        return pokemon
    }

}