package org.zenika.core;

public class Battle {

    protected FightingPokemon pokemonA;

    protected FightingPokemon pokemonB;

    protected Pokemon winner;

    protected int round;

    public Battle() {
    }

    public Battle(FightingPokemon pokemonA, FightingPokemon pokemonB) {
        this.pokemonA = pokemonA;
        this.pokemonB = pokemonB;
        this.round = 0;
    }

    public FightingPokemon getStarter() {
        return pokemonA.getFightOrder() <= pokemonB.getFightOrder() ? pokemonA : pokemonB;
    }

    public FightingPokemon getEnder() {
        return getStarter() == pokemonA ? pokemonB : pokemonA;
    }

    public BattleStatus getBattleStatus() {
        if (round == 0) {
            return BattleStatus.TO_START;
        }
        if (winner == null) {
            return BattleStatus.PENDING;
        }
        return BattleStatus.ENDED;
    }

    public FightingPokemon getPokemonA() {
        return pokemonA;
    }

    public void setPokemonA(FightingPokemon pokemonA) {
        this.pokemonA = pokemonA;
    }

    public FightingPokemon getPokemonB() {
        return pokemonB;
    }

    public void setPokemonB(FightingPokemon pokemonB) {
        this.pokemonB = pokemonB;
    }

    public Pokemon getWinner() {
        return winner;
    }

    public void setWinner(Pokemon winner) {
        this.winner = winner;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
