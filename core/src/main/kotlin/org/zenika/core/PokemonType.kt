package org.zenika.core

enum class PokemonType(val value: String) {
    POISON("poison"),
    GRASS("grass"),
    FIRE("fire"),
    FLYING("flying"),
    WATER("water"),
    BUG("bug"),
    NORMAL("normal"),
    ELECTRIC("electric"),
    GROUND("ground"),
    FAIRY("fairy"),
    FIGHTING("fighting"),
    PSYCHIC("psychic"),
    ROCK("rock"),
    STEEL("steel"),
    ICE("ice"),
    GHOST("ghost"),
    DRAGON("dragon"),
    DARK("dark");

    companion object {
        fun fromValue(value: String): PokemonType? =
                values().firstOrNull { it.value == value }
    }

}
