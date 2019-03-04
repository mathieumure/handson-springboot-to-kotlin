package org.zenika.core;

import kotlin.random.Random

class PokemonUtils {
    companion object {
        const val NORMAL = 2
        const val NULL = 0
        const val NOT_EFFECTIVE = 1
        const val VERY_EFFECTIVE = 4

        fun <T> pick(givenList: List<T>) : T = givenList[Random.nextInt(givenList.size)]

        fun pickType(pokemon: Pokemon): PokemonType = PokemonType.fromValue(pick(pokemon.types)) ?: PokemonType.NORMAL

        fun getAttackResult(attacker: Pokemon, defender: Pokemon): Int {
            val attackerType = pickType(attacker)
            val defenderType = pickType(defender)
            return when (attackerType) {
                PokemonType.POISON -> getPoisonAttackResult(defenderType)
                PokemonType.GRASS -> getGrassAttackResult(defenderType)
                PokemonType.FIRE -> getFireAttackResult(defenderType)
                PokemonType.FLYING -> getFlyingAttackResult(defenderType)
                PokemonType.WATER -> getWaterAttackResult(defenderType)
                PokemonType.BUG -> getBugAttackResult(defenderType)
                PokemonType.NORMAL -> getNormalAttackResult(defenderType)
                PokemonType.ELECTRIC -> getElectricAttackResult(defenderType)
                PokemonType.GROUND -> getGroundAttackResult(defenderType)
                PokemonType.FAIRY -> getFairyAttackResult(defenderType)
                PokemonType.FIGHTING -> getFightingAttackResult(defenderType)
                PokemonType.PSYCHIC -> getPsychicAttackResult(defenderType)
                PokemonType.ROCK -> getRockAttackResult(defenderType)
                PokemonType.STEEL -> getSteelAttackResult(defenderType)
                PokemonType.ICE -> getIceAttackResult(defenderType)
                PokemonType.GHOST -> getGhostAttackResult(defenderType)
                PokemonType.DRAGON -> getDragonAttackResult(defenderType)
                PokemonType.DARK -> getDarkAttackResult(defenderType)
            }
        }

        fun getNormalAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.ROCK, PokemonType.STEEL) -> NOT_EFFECTIVE
            PokemonType.GHOST -> NULL
            else -> NORMAL
        }


        fun getFireAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.ICE, PokemonType.GRASS, PokemonType.BUG, PokemonType.STEEL) -> VERY_EFFECTIVE
            in listOf(PokemonType.FIRE, PokemonType.WATER, PokemonType.ROCK, PokemonType.DRAGON) -> NOT_EFFECTIVE
            else -> NORMAL
        }

        fun getWaterAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.FIRE, PokemonType.GROUND, PokemonType.ROCK) -> VERY_EFFECTIVE
            in listOf(PokemonType.WATER,PokemonType.GRASS,PokemonType.DRAGON)-> NOT_EFFECTIVE
            else -> NORMAL
        }

        fun getElectricAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.WATER,PokemonType.FLYING)-> VERY_EFFECTIVE
            in listOf(PokemonType.ELECTRIC,PokemonType.GRASS,PokemonType.DRAGON) -> NOT_EFFECTIVE
            PokemonType.GROUND -> NULL
            else -> NORMAL
        }

        fun getGrassAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.WATER, PokemonType.GROUND, PokemonType.ROCK)               -> VERY_EFFECTIVE
            in listOf(PokemonType.FIRE, PokemonType.GRASS, PokemonType.POISON, PokemonType.FLYING, PokemonType.BUG, PokemonType.DRAGON, PokemonType.STEEL)
                -> NOT_EFFECTIVE
            else -> NORMAL
        }

        fun getIceAttackResult(defenderType: PokemonType) = when(defenderType) {
                in listOf(PokemonType.GRASS,
                PokemonType.GROUND,
                PokemonType.FLYING,
                PokemonType.DRAGON)
                -> VERY_EFFECTIVE;
                in listOf(PokemonType.FIRE,
                PokemonType.WATER,
                PokemonType.ICE,
                PokemonType.STEEL)
                -> NOT_EFFECTIVE
                else -> NORMAL
        }

        fun getFightingAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.NORMAL,
                PokemonType.ICE,
                PokemonType.ROCK,
                PokemonType.DARK,
                PokemonType.STEEL)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.POISON,
                PokemonType.FLYING,
                PokemonType.PSYCHIC,
                PokemonType.BUG,
                PokemonType.FAIRY)
                -> NOT_EFFECTIVE;
            PokemonType.GHOST
                -> NULL;
                else -> NORMAL;
        }

        fun getPoisonAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.GRASS,
                PokemonType.FAIRY)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.POISON,
                PokemonType.GROUND,
                PokemonType.ROCK,
                PokemonType.GHOST)
                -> NOT_EFFECTIVE
            PokemonType.STEEL
                -> NULL
                else -> NORMAL
        }

        fun getGroundAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.FIRE,
                PokemonType.ELECTRIC,
                PokemonType.POISON,
                PokemonType.ROCK,
                PokemonType.STEEL)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.GRASS,
                PokemonType.BUG)
                -> NOT_EFFECTIVE;
                PokemonType.FLYING
                -> NULL;
                else -> NORMAL;
        }

        fun getFlyingAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.GRASS,
                PokemonType.FIGHTING,
                PokemonType.BUG)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.ELECTRIC,
                PokemonType.ROCK,
                PokemonType.STEEL)
                -> NOT_EFFECTIVE;
                else -> NORMAL;
        }

        fun getPsychicAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.FIGHTING,
                PokemonType.POISON)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.PSYCHIC,
                PokemonType.STEEL)
                -> NOT_EFFECTIVE;
                PokemonType.DARK
                -> NULL;
                else -> NORMAL;
        }

        fun getBugAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.GRASS,
                PokemonType.PSYCHIC,
                PokemonType.DARK)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.FIGHTING,
                PokemonType.FIRE,
                PokemonType.POISON,
                PokemonType.FLYING,
                PokemonType.GHOST,
                PokemonType.STEEL,
                PokemonType.FAIRY)
                -> NOT_EFFECTIVE;
                else -> NORMAL;
        }

        fun getRockAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.FIRE,
                PokemonType.ICE,
                PokemonType.BUG,
                PokemonType.FLYING)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.FIGHTING,
                PokemonType.GROUND,
                PokemonType.STEEL)
                -> NOT_EFFECTIVE;
                else -> NORMAL;
        }

        fun getGhostAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.PSYCHIC,
                PokemonType.GHOST)
                -> VERY_EFFECTIVE;
                PokemonType.DARK
                -> NOT_EFFECTIVE;
                PokemonType.NORMAL
                -> NULL;
                else -> NORMAL;
        }

        fun getDragonAttackResult(defenderType: PokemonType) = when(defenderType) {
                PokemonType.DRAGON
                -> VERY_EFFECTIVE;
                PokemonType.STEEL
                -> NOT_EFFECTIVE;
                PokemonType.FAIRY
                -> NULL;
                else -> NORMAL;
        }

        fun getDarkAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.PSYCHIC,
                PokemonType.GHOST)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.FIGHTING,
                PokemonType.DARK,
                PokemonType.FAIRY)
                -> NOT_EFFECTIVE;
                else -> NORMAL;
        }

        fun getSteelAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.ICE,
                PokemonType.ROCK,
                PokemonType.FAIRY)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.FIRE,
                PokemonType.WATER,
                PokemonType.ELECTRIC,
                PokemonType.STEEL)
                -> NOT_EFFECTIVE;
                else -> NORMAL;
        }

        fun getFairyAttackResult(defenderType: PokemonType) = when(defenderType) {
            in listOf(PokemonType.FIGHTING,
                PokemonType.DRAGON,
                PokemonType.DARK)
                -> VERY_EFFECTIVE;
            in listOf(PokemonType.FIRE,
                PokemonType.POISON,
                PokemonType.STEEL)
                -> NOT_EFFECTIVE;
                else -> NORMAL;
        }
    }
}
