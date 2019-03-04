package org.zenika.core;

class FightingPokemon(pokemon: Pokemon, var life: Int, var fightOrder: Int) : Pokemon(pokemon) {

    fun isKO(): Boolean = this.life <= 0

    fun receiveDamage(amount: Int) = {
        this.life -= amount
    }

}
