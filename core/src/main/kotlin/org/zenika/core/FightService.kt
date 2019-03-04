package org.zenika.core;

import java.util.Arrays;

class FightService {
    companion object {
        const val INTIAL_PV = 20;
        fun startBattle(pokemonA: Pokemon, pokemonB: Pokemon) : Battle {
            val fightingPokemonA = FightingPokemon(pokemonA, INTIAL_PV, 1)
            val fightingPokemonB = FightingPokemon(pokemonB, INTIAL_PV, 1)

            val starter : FightingPokemon = PokemonUtils.pick(Arrays.asList(fightingPokemonA, fightingPokemonB));
            starter.fightOrder = 0;
            return Battle(fightingPokemonA, fightingPokemonB)
        }
        fun nextRound(battle: Battle) : Battle {
            val starter = battle.getStarter()
            val ender = battle.getEnder()

            val starterAttackResult = PokemonUtils.getAttackResult(starter, ender)
            ender.receiveDamage(starterAttackResult)

            val enderAttackResult = PokemonUtils.getAttackResult(ender, starter)
            starter.receiveDamage(enderAttackResult);

            battle.round = battle.round + 1

            return battle
        }
    }
}