package org.zenika.webapp.service;

import org.springframework.stereotype.Service;
import org.zenika.core.Pokemon;
import org.zenika.webapp.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll().stream().map(pokemon -> pokemon.toPokemon()).collect(Collectors.toList());
    }

    public Pokemon getPokemonByIdOrName(String idOrName) {
        final Optional<org.zenika.webapp.entity.Pokemon> pokemonByName = pokemonRepository.findByName(idOrName);
        if (pokemonByName.isPresent()) {
            return pokemonByName.get().toPokemon();
        }

        Optional<org.zenika.webapp.entity.Pokemon> pokemonById = pokemonRepository.findById(Long.parseLong(idOrName));
        if (pokemonById.isPresent()) {
            return pokemonById.get().toPokemon();
        }
        return null;
    }

    public List<String> getAllPokemonTypes() {
        return getAllPokemon().stream()
                .map(it -> it.getTypes())
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public Pokemon fight(String idPokemon1, String idPokemon2) {
        Pokemon pokemon1 = getPokemonByIdOrName(idPokemon1);
        Pokemon pokemon2 = getPokemonByIdOrName(idPokemon2);

        if (pokemon1 == null || pokemon2 == null) {
            return null;
        }

        Random random = new Random();
        int i = random.nextInt();
        if (i % 2 == 0) {
            return pokemon1;
        } else {
            return pokemon2;
        }
    }
}
