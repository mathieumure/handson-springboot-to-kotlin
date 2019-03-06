package org.zenika.arena.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.zenika.arena.entity.BattleEntity
import org.zenika.arena.repository.BattleRepository
import org.zenika.core.BattleStatus
import org.zenika.core.FightService
import org.zenika.core.Pokemon

@Service
class ArenaService(val battleRepository: BattleRepository) {

    fun startFight(pokemons: List<Pokemon>): BattleEntity =
    FightService.startBattle(pokemons[0], pokemons[1]).let {
        battleRepository.save(BattleEntity(it))
    }

    fun getBattle(id: String): BattleEntity = battleRepository.findById(id).get()

    fun getUnfinishedBattle(): List<BattleEntity> = battleRepository.findAllByWinnerIsNull()

    fun updateBattle(battle: BattleEntity): BattleEntity = battleRepository.save(battle)

    fun getBattleStatus(id: String): BattleStatus? = battleRepository.findByIdOrNull(id)?.battleStatus
}
