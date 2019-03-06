package org.zenika.api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.zenika.api.service.PokemonService
import org.zenika.core.Battle
import org.zenika.core.Pokemon

@RestController
@RequestMapping("/pokemons")
class PokemonsController(val pokemonService: PokemonService) {

    private fun <T> T?.wrap(): ResponseEntity<T> =
            this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()


    @GetMapping
    fun getAllPokemons(): List<Pokemon> = pokemonService.getAllPokemon()

    @GetMapping("/{idOrName}")
    fun getPokemonById(@PathVariable idOrName: String): ResponseEntity<Pokemon> =
            pokemonService.getPokemonByIdOrName(idOrName).wrap()

    @GetMapping("/types")
    fun getPokemonTypes() : List<String> = pokemonService.getAllPokemonTypes()

    @GetMapping("/{idPokemon1}/vs/{idPokemon2}")
    fun fight(@PathVariable idPokemon1: String, @PathVariable idPokemon2: String): ResponseEntity<Battle> =
            pokemonService.fight(idPokemon1, idPokemon2).wrap()

    @GetMapping("/battle/{id}")
    fun getBattle(@PathVariable id: String): ResponseEntity<Battle> = pokemonService.getBattle(id).wrap()
}
