package org.zenika.api.controller;

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.zenika.api.service.PokemonService
import org.zenika.core.Battle
import org.zenika.core.Pokemon

@RestController
@RequestMapping("/pokemons")
class PokemonsController(val pokemonService: PokemonService) {

    @GetMapping
    fun getAllPokemons(): List<Pokemon> = pokemonService.getAllPokemon()

    @GetMapping("/{idOrName}")
    fun getPokemonById(@PathVariable idOrName: String): ResponseEntity<Pokemon> {
        val pokemon = pokemonService.getPokemonByIdOrName(idOrName) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pokemon)
    }

    @GetMapping("/types")
    fun getPokemonTypes() : List<String> = pokemonService.getAllPokemonTypes()

    @GetMapping("/{idPokemon1}/vs/{idPokemon2}")
    fun fight(@PathVariable idPokemon1: String, @PathVariable idPokemon2: String): ResponseEntity<Battle> {
        val battle = pokemonService.fight(idPokemon1, idPokemon2) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(battle)
    }

    @GetMapping("/battle/{id}")
    fun getBattle(@PathVariable id: String): ResponseEntity<Battle> {
        val battle = pokemonService.getBattle(id)
        return ResponseEntity.ok(battle)
    }
}
