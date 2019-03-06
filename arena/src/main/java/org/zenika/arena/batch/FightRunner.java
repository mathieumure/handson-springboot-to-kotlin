package org.zenika.arena.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zenika.arena.entity.BattleEntity;
import org.zenika.arena.service.ArenaService;
import org.zenika.core.Battle;
import org.zenika.core.FightService;

import java.util.List;

@Component
public class FightRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(FightRunner.class);
    private ArenaService arenaService;

    public FightRunner(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 3000)
    public void processFight () {

        LOGGER.info("START processing fights");
        List<BattleEntity> battles = arenaService.getUnfinishedBattle();
        LOGGER.info("Found {} unfinished fights", battles.size());

        for (BattleEntity battle : battles) {
            FightService.nextRound(battle);
            if (battle.getPokemonA().isKO()) {
                LOGGER.info("PokemonB is the winner");
                battle.setWinner(battle.getPokemonB());
            }
            if (battle.getPokemonB().isKO()) {
                LOGGER.info("PokemonA is the winner");
                battle.setWinner(battle.getPokemonA());
            }
            LOGGER.info("PokemonA {} vs PokemonB {}", battle.getPokemonA().getLife(), battle.getPokemonB().getLife());
            arenaService.updateBattle(battle);
        }

    }


}
