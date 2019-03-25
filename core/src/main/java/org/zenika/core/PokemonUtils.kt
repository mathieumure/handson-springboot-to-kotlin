package org.zenika.core

import java.util.*


const val NORMAL = 2
const val NULL = 0
const val NOT_EFFECTIVE = 1
const val VERY_EFFECTIVE = 4

object PokemonUtils {

    private val random = Random()

    private fun randomPickType(pokemon: Pokemon): PokemonType {
        val types = pokemon.types
        val pickedType = types.pick()
        return PokemonType.fromValue(pickedType)
    }

    @JvmStatic
    fun <T> List<T>.pick(): T = this[random.nextInt(size)]

    @JvmOverloads
    @JvmStatic
    fun getAttackResult(
            attacker: Pokemon,
            defender: Pokemon,
            pickType: (Pokemon) -> PokemonType = PokemonUtils::randomPickType
    ): Int {
        val attackerType = pickType(attacker)
        val defenderType = pickType(defender)
        return when (attackerType) {
            PokemonType.POISON   -> getPoisonAttackResult(defenderType)
            PokemonType.GRASS    -> getGrassAttackResult(defenderType)
            PokemonType.FIRE     -> getFireAttackResult(defenderType)
            PokemonType.FLYING   -> getFlyingAttackResult(defenderType)
            PokemonType.WATER    -> getWaterAttackResult(defenderType)
            PokemonType.BUG      -> getBugAttackResult(defenderType)
            PokemonType.NORMAL   -> getNormalAttackResult(defenderType)
            PokemonType.ELECTRIC -> getElectricAttackResult(defenderType)
            PokemonType.GROUND   -> getGroundAttackResult(defenderType)
            PokemonType.FAIRY    -> getFairyAttackResult(defenderType)
            PokemonType.FIGHTING -> getFightingAttackResult(defenderType)
            PokemonType.PSYCHIC  -> getPsychicAttackResult(defenderType)
            PokemonType.ROCK     -> getRockAttackResult(defenderType)
            PokemonType.STEEL    -> getSteelAttackResult(defenderType)
            PokemonType.ICE      -> getIceAttackResult(defenderType)
            PokemonType.GHOST    -> getGhostAttackResult(defenderType)
            PokemonType.DRAGON   -> getDragonAttackResult(defenderType)
            PokemonType.DARK     -> getDarkAttackResult(defenderType)
        }
    }

    private fun getNormalAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.ROCK, PokemonType.STEEL -> NOT_EFFECTIVE
            PokemonType.GHOST                   -> NULL
            else                                -> NORMAL
        }
    }

    private fun getFireAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.ICE, PokemonType.GRASS, PokemonType.BUG, PokemonType.STEEL    -> VERY_EFFECTIVE
            PokemonType.FIRE, PokemonType.WATER, PokemonType.ROCK, PokemonType.DRAGON -> NOT_EFFECTIVE
            else                                                                      -> NORMAL
        }
    }

    private fun getWaterAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.FIRE, PokemonType.GROUND, PokemonType.ROCK   -> VERY_EFFECTIVE
            PokemonType.WATER, PokemonType.GRASS, PokemonType.DRAGON -> NOT_EFFECTIVE
            else                                                     -> NORMAL
        }
    }

    private fun getElectricAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.WATER, PokemonType.FLYING                       -> VERY_EFFECTIVE
            PokemonType.ELECTRIC, PokemonType.GRASS, PokemonType.DRAGON -> NOT_EFFECTIVE
            PokemonType.GROUND                                          -> NULL
            else                                                        -> NORMAL
        }
    }

    private fun getGrassAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.WATER, PokemonType.GROUND, PokemonType.ROCK                                                                             -> VERY_EFFECTIVE
            PokemonType.FIRE, PokemonType.GRASS, PokemonType.POISON, PokemonType.FLYING, PokemonType.BUG, PokemonType.DRAGON, PokemonType.STEEL -> NOT_EFFECTIVE
            else                                                                                                                                -> NORMAL
        }
    }

    private fun getIceAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.GRASS, PokemonType.GROUND, PokemonType.FLYING, PokemonType.DRAGON -> VERY_EFFECTIVE
            PokemonType.FIRE, PokemonType.WATER, PokemonType.ICE, PokemonType.STEEL       -> NOT_EFFECTIVE
            else                                                                          -> NORMAL
        }
    }

    private fun getFightingAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.NORMAL, PokemonType.ICE, PokemonType.ROCK, PokemonType.DARK, PokemonType.STEEL      -> VERY_EFFECTIVE
            PokemonType.POISON, PokemonType.FLYING, PokemonType.PSYCHIC, PokemonType.BUG, PokemonType.FAIRY -> NOT_EFFECTIVE
            PokemonType.GHOST                                                                               -> NULL
            else                                                                                            -> NORMAL
        }
    }

    private fun getPoisonAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.GRASS, PokemonType.FAIRY                                        -> VERY_EFFECTIVE
            PokemonType.POISON, PokemonType.GROUND, PokemonType.ROCK, PokemonType.GHOST -> NOT_EFFECTIVE
            PokemonType.STEEL                                                           -> NULL
            else                                                                        -> NORMAL
        }
    }

    private fun getGroundAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.FIRE, PokemonType.ELECTRIC, PokemonType.POISON, PokemonType.ROCK, PokemonType.STEEL -> VERY_EFFECTIVE
            PokemonType.GRASS, PokemonType.BUG                                                              -> NOT_EFFECTIVE
            PokemonType.FLYING                                                                              -> NULL
            else                                                                                            -> NORMAL
        }
    }

    private fun getFlyingAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.GRASS, PokemonType.FIGHTING, PokemonType.BUG  -> VERY_EFFECTIVE
            PokemonType.ELECTRIC, PokemonType.ROCK, PokemonType.STEEL -> NOT_EFFECTIVE
            else                                                      -> NORMAL
        }
    }

    private fun getPsychicAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.FIGHTING, PokemonType.POISON -> VERY_EFFECTIVE
            PokemonType.PSYCHIC, PokemonType.STEEL   -> NOT_EFFECTIVE
            PokemonType.DARK                         -> NULL
            else                                     -> NORMAL
        }
    }

    private fun getBugAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.GRASS, PokemonType.PSYCHIC, PokemonType.DARK                                                                                -> VERY_EFFECTIVE
            PokemonType.FIGHTING, PokemonType.FIRE, PokemonType.POISON, PokemonType.FLYING, PokemonType.GHOST, PokemonType.STEEL, PokemonType.FAIRY -> NOT_EFFECTIVE
            else                                                                                                                                    -> NORMAL
        }
    }

    private fun getRockAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.FIRE, PokemonType.ICE, PokemonType.BUG, PokemonType.FLYING -> VERY_EFFECTIVE
            PokemonType.FIGHTING, PokemonType.GROUND, PokemonType.STEEL            -> NOT_EFFECTIVE
            else                                                                   -> NORMAL
        }
    }

    private fun getGhostAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.PSYCHIC, PokemonType.GHOST -> VERY_EFFECTIVE
            PokemonType.DARK                       -> NOT_EFFECTIVE
            PokemonType.NORMAL                     -> NULL
            else                                   -> NORMAL
        }
    }

    private fun getDragonAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.DRAGON -> VERY_EFFECTIVE
            PokemonType.STEEL  -> NOT_EFFECTIVE
            PokemonType.FAIRY  -> NULL
            else               -> NORMAL
        }
    }

    private fun getDarkAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.PSYCHIC, PokemonType.GHOST                    -> VERY_EFFECTIVE
            PokemonType.FIGHTING, PokemonType.DARK, PokemonType.FAIRY -> NOT_EFFECTIVE
            else                                                      -> NORMAL
        }
    }

    private fun getSteelAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.ICE, PokemonType.ROCK, PokemonType.FAIRY                         -> VERY_EFFECTIVE
            PokemonType.FIRE, PokemonType.WATER, PokemonType.ELECTRIC, PokemonType.STEEL -> NOT_EFFECTIVE
            else                                                                         -> NORMAL
        }
    }

    private fun getFairyAttackResult(defenderType: PokemonType): Int {
        return when (defenderType) {
            PokemonType.FIGHTING, PokemonType.DRAGON, PokemonType.DARK -> VERY_EFFECTIVE
            PokemonType.FIRE, PokemonType.POISON, PokemonType.STEEL    -> NOT_EFFECTIVE
            else                                                       -> NORMAL
        }
    }
}
