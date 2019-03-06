package org.zenika.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.zenika.api.entity.Pokemon;

interface PokemonRepository : CrudRepository<Pokemon, Long> {
    fun findByName(name: String): Pokemon?
}
