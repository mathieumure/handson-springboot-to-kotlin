package org.zenika.core;

open class Battle(var pokemonA: FightingPokemon, var pokemonB: FightingPokemon) {
    var winner: Pokemon? = null
    var round: Int = 0

    fun getStarter() : FightingPokemon = if (pokemonA.fightOrder <= pokemonB.fightOrder) pokemonA else pokemonB

    fun getEnder(): FightingPokemon = if (getStarter() == pokemonA) pokemonB else pokemonA

    fun getBattleStatus(): BattleStatus {
        if (round == 0) {
            return BattleStatus.TO_START
        }
        if (winner == null) {
            return BattleStatus.PENDING
        }
        return BattleStatus.ENDED
    }
}
