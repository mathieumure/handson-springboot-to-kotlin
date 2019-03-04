package org.zenika.arena.repository;

import org.springframework.data.mongodb.repository.MongoRepository
import org.zenika.arena.entity.BattleEntity;


interface BattleRepository: MongoRepository<BattleEntity, String> {

    fun findAllByWinnerIsNull(): List<BattleEntity>

}
