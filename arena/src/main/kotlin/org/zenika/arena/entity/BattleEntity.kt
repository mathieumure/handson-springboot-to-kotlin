package org.zenika.arena.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import org.zenika.core.Battle
import org.zenika.core.FightingPokemon
import org.zenika.core.Pokemon

@Document(collection="battle")
@TypeAlias("battle")
class BattleEntity(pokemonA: FightingPokemon, pokemonB: FightingPokemon): Battle(pokemonA, pokemonB) {

    constructor(battle: Battle) : this(battle.pokemonA, battle.pokemonB) {
        this.apply {
            winner = battle.winner
            round = battle.round
        }
    }

    @Id
    var id: String? = null
}
