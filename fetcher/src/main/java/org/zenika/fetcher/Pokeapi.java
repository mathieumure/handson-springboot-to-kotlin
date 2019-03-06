package org.zenika.fetcher;

import feign.Param;
import feign.RequestLine;

public interface Pokeapi {

    @RequestLine("GET /api/v2/pokemon/{id}/")
    PokemonData get(@Param("id") int id);

}
