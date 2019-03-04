package org.zenika.api.service;

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import org.zenika.api.client.ArenaApi;
import org.zenika.api.entity.BattleEntity
import org.zenika.core.Battle;
import org.zenika.core.Pokemon;
import org.zenika.api.repository.PokemonRepository;

@Service
class PokemonService(val pokemonRepository: PokemonRepository, val arenaApi: ArenaApi) {

    fun getAllPokemon(): List<Pokemon> = pokemonRepository.findAll().map { it.toPokemon() }

    fun getPokemonByIdOrName(idOrName: String): Pokemon? {
        val pokemonByName = pokemonRepository.findByName(idOrName)
        if (pokemonByName != null) {
            return pokemonByName.toPokemon()
        }
        return pokemonRepository.findByIdOrNull(idOrName.toLong())?.toPokemon()
    }

    fun getAllPokemonTypes(): List<String> = getAllPokemon().flatMap { it.types }.distinct()

    fun fight(idPokemon1: String, idPokemon2: String): Battle? {
        val pokemon1 = getPokemonByIdOrName(idPokemon1)
        val pokemon2 = getPokemonByIdOrName(idPokemon2)
        if (pokemon1 == null && pokemon2 == null) {
            return null
        }
        return arenaApi.fight(listOfNotNull(pokemon1, pokemon2))
    }

    fun getBattle(id: String) = arenaApi.get(id)
}
