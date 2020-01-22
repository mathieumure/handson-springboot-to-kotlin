package org.zenika.arena.service;

import org.springframework.stereotype.Service;
import org.zenika.arena.entity.BattleEntity;
import org.zenika.arena.repository.BattleRepository;
import org.zenika.core.Battle;
import org.zenika.core.BattleStatus;
import org.zenika.core.FightService;
import org.zenika.core.Pokemon;

import java.util.List;
import java.util.Optional;

@Service
public class ArenaService {

    private BattleRepository battleRepository;

    public ArenaService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public BattleEntity startFight(List<Pokemon> pokemons) {
        Battle battle = FightService.startBattle(pokemons.get(0), pokemons.get(1));
        return battleRepository.save(new BattleEntity(battle));
    }

    public BattleEntity getBattle(String id) {
        return battleRepository.findById(id).get();
    }

    public List<BattleEntity> getUnfinishedBattle() {
        return battleRepository.findAllByWinnerIsNull();
    }

    public BattleEntity updateBattle(BattleEntity battle) {
        return battleRepository.save(battle);
    }

    public BattleStatus getBattleStatus(String id) {
        Optional<BattleEntity> battleEntityOptional = battleRepository.findById(id);
        if (battleEntityOptional.isPresent()) {
            return battleEntityOptional.get().getBattleStatus();
        }
        return null;
    }
}
