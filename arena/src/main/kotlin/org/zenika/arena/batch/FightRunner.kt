package org.zenika.arena.batch;

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.zenika.arena.entity.BattleEntity
import org.zenika.arena.service.ArenaService
import org.zenika.core.FightService

@Component
class FightRunner(val arenaService: ArenaService) {

    private val LOGGER: Logger = LoggerFactory.getLogger(javaClass)

    @Scheduled(initialDelay = 5000, fixedRate = 3000)
    fun processFight () {
        LOGGER.info("START processing fights")
        val battles = arenaService.getUnfinishedBattle()
        LOGGER.info("Found {} unfinished fights", battles.size)
        for (battle in battles) {
            FightService.nextRound(battle);
            if (battle.pokemonA.isKO) {
                LOGGER.info("PokemonB is the winner")
                battle.winner = battle.pokemonB;
            }
            if (battle.pokemonB.isKO()) {
                LOGGER.info("PokemonA is the winner")
                battle.winner = battle.pokemonA;
            }
            LOGGER.info("PokemonA {} vs PokemonB {}", battle.pokemonA.life, battle.pokemonB.life)
            arenaService.updateBattle(battle)
        }

    }


}
