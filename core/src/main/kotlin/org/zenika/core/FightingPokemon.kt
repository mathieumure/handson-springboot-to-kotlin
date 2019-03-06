package org.zenika.core

class FightingPokemon(var pokemon: Pokemon, var life: Int, var fightOrder: Int) : Pokemon(pokemon) {

    val isKO: Boolean
        get() = this.life <= 0

    fun receiveDamage(amount: Int) {
        this.life = this.life - amount
    }

}
