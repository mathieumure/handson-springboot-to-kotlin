package org.zenika.core

open class Battle(var pokemonA: FightingPokemon, var pokemonB: FightingPokemon) {
    var winner: Pokemon? = null

    var round: Int = 0

    val starter: FightingPokemon
        get() = if (pokemonA.fightOrder <= pokemonB.fightOrder) pokemonA else pokemonB

    val ender: FightingPokemon
        get() = if (starter == pokemonA) pokemonB else pokemonA

    val battleStatus: BattleStatus
            get() = when {
                round == 0 -> BattleStatus.TO_START
                winner == null -> BattleStatus.PENDING
                else -> BattleStatus.ENDED
            }

}

