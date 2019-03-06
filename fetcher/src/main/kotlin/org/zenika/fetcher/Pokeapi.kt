package org.zenika.fetcher

import feign.Param
import feign.RequestLine

interface Pokeapi {

    @RequestLine("GET /api/v2/pokemon/{id}/")
    fun get(@Param("id") id: Int): PokemonData

}
