package org.zenika.api.service;

import org.springframework.stereotype.Service;
import org.zenika.api.client.ArenaApi;
import org.zenika.core.Battle;
import org.zenika.core.Pokemon;
import org.zenika.api.repository.PokemonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;
    private ArenaApi arenaApi;

    public PokemonService(PokemonRepository pokemonRepository, ArenaApi arenaApi) {
        this.pokemonRepository = pokemonRepository;
        this.arenaApi = arenaApi;
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll().stream().map(pokemon -> pokemon.toPokemon()).collect(Collectors.toList());
    }

    public Pokemon getPokemonByIdOrName(String idOrName) {
        final Optional<org.zenika.api.entity.Pokemon> pokemonByName = pokemonRepository.findByName(idOrName);
        if (pokemonByName.isPresent()) {
            return pokemonByName.get().toPokemon();
        }

        Optional<org.zenika.api.entity.Pokemon> pokemonById = pokemonRepository.findById(Long.parseLong(idOrName));
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

    public Battle fight(String idPokemon1, String idPokemon2) {
        Pokemon pokemon1 = getPokemonByIdOrName(idPokemon1);
        Pokemon pokemon2 = getPokemonByIdOrName(idPokemon2);

        if (pokemon1 == null || pokemon2 == null) {
            return null;
        }
        return arenaApi.fight(Arrays.asList(pokemon1, pokemon2));
    }

    public Battle getBattle(String id) {
        return arenaApi.get(id);
    }
}
