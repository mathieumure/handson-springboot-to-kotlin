package org.zenika.api.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.zenika.api.entity.BattleEntity;
import org.zenika.core.BattleStatus;
import org.zenika.core.Pokemon;

import java.util.List;

public interface ArenaApi {

    @RequestLine("POST /fight")
    @Headers("Content-Type: application/json")
    BattleEntity fight(List<Pokemon> pokemons);

    @RequestLine("GET /fight/{id}")
    BattleEntity get(@Param("id") String id);

    @RequestLine("GET /fight/{id}/status")
    BattleStatus getStatus(@Param("id") String id);

}
