package org.zenika.core;

import java.util.Arrays;

public class FightService {

    public static final int INTIAL_PV = 20;

    public static final Battle startBattle(Pokemon pokemonA, Pokemon pokemonB) {
        FightingPokemon fightingPokemonA = new FightingPokemon(pokemonA, INTIAL_PV, 1);
        FightingPokemon fightingPokemonB = new FightingPokemon(pokemonB, INTIAL_PV, 1);

        FightingPokemon starter = PokemonUtils.pick(Arrays.asList(fightingPokemonA, fightingPokemonB));
        starter.setFightOrder(0);
        return new Battle(fightingPokemonA, fightingPokemonB);
    }

    public static final Battle nextRound(Battle battle) {
        FightingPokemon starter = battle.getStarter();
        FightingPokemon ender = battle.getEnder();

        int starterAttackResult = PokemonUtils.getAttackResult(starter, ender);
        ender.receiveDamage(starterAttackResult);

        int enderAttackResult = PokemonUtils.getAttackResult(ender, starter);
        starter.receiveDamage(enderAttackResult);

        battle.setRound(battle.getRound() + 1);

        return battle;

    }

}
