package org.zenika.arena.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.zenika.arena.entity.BattleEntity;

import java.util.List;

public interface BattleRepository extends MongoRepository<BattleEntity, String> {

    List<BattleEntity> findAllByWinnerIsNull();

}
