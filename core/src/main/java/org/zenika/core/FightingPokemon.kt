package org.zenika.core;

public class FightingPokemon extends Pokemon {

    private int life;

    private int fightOrder;

    public FightingPokemon() {
    }

    public FightingPokemon(Pokemon pokemon, int life, int fightOrder) {
        super(pokemon);
        this.life = life;
        this.fightOrder = fightOrder;
    }

    public boolean isKO() {
        return this.life <= 0;
    }

    public void receiveDamage(int amount) {
        life -= amount;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getFightOrder() {
        return fightOrder;
    }

    public void setFightOrder(int fightOrder) {
        this.fightOrder = fightOrder;
    }
}
