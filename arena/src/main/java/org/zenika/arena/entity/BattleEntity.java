package org.zenika.arena.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.zenika.core.Battle;
import org.zenika.core.FightingPokemon;

@Document(collection="battle")
@TypeAlias("battle")
public class BattleEntity extends Battle {

    @Id
    private String id;

    public BattleEntity() {
        super();
    }

    public BattleEntity(Battle battle) {
        super(battle.getPokemonA(), battle.getPokemonB());
        this.setRound(battle.getRound());
        this.setWinner(battle.getWinner());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
