package org.zenika.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.zenika.api.entity.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    List<Pokemon> findAll();

    Optional<Pokemon> findByName(String name);
}
