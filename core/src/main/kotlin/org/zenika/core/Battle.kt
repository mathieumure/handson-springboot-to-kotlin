package org.zenika.core;

open class Battle(var pokemonA: FightingPokemon, var pokemonB: FightingPokemon) {
    var winner: Pokemon? = null
        protected set

    var round: Int = 0

    fun getStarter() : FightingPokemon = if (pokemonA.fightOrder <= pokemonB.fightOrder) pokemonA else pokemonB

    fun getEnder(): FightingPokemon = if (getStarter() == pokemonA) pokemonB else pokemonA

    fun getBattleStatus(): BattleStatus = when {
        round == 0 -> BattleStatus.TO_START
        winner == null -> BattleStatus.PENDING
        else -> BattleStatus.ENDED
    }

}

