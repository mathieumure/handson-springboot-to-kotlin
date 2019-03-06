package org.zenika.arena.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import org.zenika.core.Battle

@Document(collection="battle")
@TypeAlias("battle")
class BattleEntity(battle: Battle): Battle() {

    @Id
    var id: String? = null

    init {
        super.pokemonA = battle.pokemonA
        super.pokemonB = battle.pokemonB
        super.round = battle.round
        super.winner = battle.winner
    }

}
