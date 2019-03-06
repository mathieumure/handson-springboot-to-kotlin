package org.zenika.api.client

import feign.Headers
import feign.Param
import feign.RequestLine
import org.zenika.api.entity.BattleEntity
import org.zenika.core.Pokemon

interface ArenaApi {

    @RequestLine("POST /fight")
    @Headers("Content-Type: application/json")
    fun fight(pokemons: List<Pokemon>): BattleEntity

    @RequestLine("GET /fight/{id}")
    fun get(@Param("id") id: String): BattleEntity

    @RequestLine("GET /fight/{id}/status")
    fun getStatus(@Param("id") id: String): BattleEntity
}
