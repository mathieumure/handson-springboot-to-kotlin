package org.zenika.core;

import java.util.List;
import java.util.Random;

public class PokemonUtils {

    private static final int NORMAL = 2;
    private static final int NULL = 0;
    private static final int NOT_EFFECTIVE = 1;
    private static final int VERY_EFFECTIVE = 4;
    private static final Random random = new Random();

    public static final PokemonType pickType(Pokemon pokemon) {
        List<String> types = pokemon.getTypes();
        String pickedType = pick(types);
        return PokemonType.fromValue(pickedType);
    }

    public static final <T> T pick(List<T> givenList) {
        return givenList.get(random.nextInt(givenList.size()));
    }

    public static final int getAttackResult(Pokemon attacker, Pokemon defender) {
        PokemonType attackerType = pickType(attacker);
        PokemonType defenderType = pickType(defender);
        switch (attackerType) {
            case POISON:
                return getPoisonAttackResult(defenderType);
            case GRASS:
                return getGrassAttackResult(defenderType);
            case FIRE:
                return getFireAttackResult(defenderType);
            case FLYING:
                return getFlyingAttackResult(defenderType);
            case WATER:
                return getWaterAttackResult(defenderType);
            case BUG:
                return getBugAttackResult(defenderType);
            case NORMAL:
                return getNormalAttackResult(defenderType);
            case ELECTRIC:
                return getElectricAttackResult(defenderType);
            case GROUND:
                return getGroundAttackResult(defenderType);
            case FAIRY:
                return getFairyAttackResult(defenderType);
            case FIGHTING:
                return getFightingAttackResult(defenderType);
            case PSYCHIC:
                return getPsychicAttackResult(defenderType);
            case ROCK:
                return getRockAttackResult(defenderType);
            case STEEL:
                return getSteelAttackResult(defenderType);
            case ICE:
                return getIceAttackResult(defenderType);
            case GHOST:
                return getGhostAttackResult(defenderType);
            case DRAGON:
                return getDragonAttackResult(defenderType);
            case DARK:
                return getDarkAttackResult(defenderType);
        }
        return NORMAL;
    }

    public static final int getNormalAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case ROCK:
            case STEEL:
                return NOT_EFFECTIVE;
            case GHOST:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getFireAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case ICE:
            case GRASS:
            case BUG:
            case STEEL:
                return VERY_EFFECTIVE;
            case FIRE:
            case WATER:
            case ROCK:
            case DRAGON:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getWaterAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case FIRE:
            case GROUND:
            case ROCK:
                return VERY_EFFECTIVE;
            case WATER:
            case GRASS:
            case DRAGON:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getElectricAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case WATER:
            case FLYING:
                return VERY_EFFECTIVE;
            case ELECTRIC:
            case GRASS:
            case DRAGON:
                return NOT_EFFECTIVE;
            case GROUND:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getGrassAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case WATER:
            case GROUND:
            case ROCK:
                return VERY_EFFECTIVE;
            case FIRE:
            case GRASS:
            case POISON:
            case FLYING:
            case BUG:
            case DRAGON:
            case STEEL:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getIceAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case GRASS:
            case GROUND:
            case FLYING:
            case DRAGON:
                return VERY_EFFECTIVE;
            case FIRE:
            case WATER:
            case ICE:
            case STEEL:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getFightingAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case NORMAL:
            case ICE:
            case ROCK:
            case DARK:
            case STEEL:
                return VERY_EFFECTIVE;
            case POISON:
            case FLYING:
            case PSYCHIC:
            case BUG:
            case FAIRY:
                return NOT_EFFECTIVE;
            case GHOST:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getPoisonAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case GRASS:
            case FAIRY:
                return VERY_EFFECTIVE;
            case POISON:
            case GROUND:
            case ROCK:
            case GHOST:
                return NOT_EFFECTIVE;
            case STEEL:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getGroundAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case FIRE:
            case ELECTRIC:
            case POISON:
            case ROCK:
            case STEEL:
                return VERY_EFFECTIVE;
            case GRASS:
            case BUG:
                return NOT_EFFECTIVE;
            case FLYING:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getFlyingAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case GRASS:
            case FIGHTING:
            case BUG:
                return VERY_EFFECTIVE;
            case ELECTRIC:
            case ROCK:
            case STEEL:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getPsychicAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case FIGHTING:
            case POISON:
                return VERY_EFFECTIVE;
            case PSYCHIC:
            case STEEL:
                return NOT_EFFECTIVE;
            case DARK:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getBugAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case GRASS:
            case PSYCHIC:
            case DARK:
                return VERY_EFFECTIVE;
            case FIGHTING:
            case FIRE:
            case POISON:
            case FLYING:
            case GHOST:
            case STEEL:
            case FAIRY:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getRockAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case FIRE:
            case ICE:
            case BUG:
            case FLYING:
                return VERY_EFFECTIVE;
            case FIGHTING:
            case GROUND:
            case STEEL:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getGhostAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case PSYCHIC:
            case GHOST:
                return VERY_EFFECTIVE;
            case DARK:
                return NOT_EFFECTIVE;
            case NORMAL:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getDragonAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case DRAGON:
                return VERY_EFFECTIVE;
            case STEEL:
                return NOT_EFFECTIVE;
            case FAIRY:
                return NULL;
            default: return NORMAL;
        }
    }

    public static final int getDarkAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case PSYCHIC:
            case GHOST:
                return VERY_EFFECTIVE;
            case FIGHTING:
            case DARK:
            case FAIRY:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getSteelAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case ICE:
            case ROCK:
            case FAIRY:
                return VERY_EFFECTIVE;
            case FIRE:
            case WATER:
            case ELECTRIC:
            case STEEL:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }

    public static final int getFairyAttackResult(PokemonType defenderType) {
        switch (defenderType) {
            case FIGHTING:
            case DRAGON:
            case DARK:
                return VERY_EFFECTIVE;
            case FIRE:
            case POISON:
            case STEEL:
                return NOT_EFFECTIVE;
            default: return NORMAL;
        }
    }
}
