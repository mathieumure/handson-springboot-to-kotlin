package org.zenika.core;

public enum PokemonType {
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

    private String value;

    PokemonType(String value) {
        this.value = value;
    }

    public static PokemonType fromValue(String value) {
        for(PokemonType type : PokemonType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
