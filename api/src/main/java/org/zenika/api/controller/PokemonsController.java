package org.zenika.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zenika.core.Battle;
import org.zenika.core.Pokemon;
import org.zenika.api.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonsController {

    private PokemonService pokemonService;

    public PokemonsController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{idOrName}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable String idOrName) {
        Pokemon pokemon = pokemonService.getPokemonByIdOrName(idOrName);
        if (pokemon == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pokemon);
    }

    @GetMapping("/types")
    public List<String> getPokemonTypes() {
        return pokemonService.getAllPokemonTypes();
    }

    @GetMapping("/{idPokemon1}/vs/{idPokemon2}")
    public ResponseEntity<Battle> fight(@PathVariable String idPokemon1, @PathVariable String idPokemon2) {
        Battle battle = pokemonService.fight(idPokemon1, idPokemon2);
        if (battle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(battle);
    }

    @GetMapping("/battle/{id}")
    public ResponseEntity<Battle> getBattle(@PathVariable String id) {
        Battle battle = pokemonService.getBattle(id);
        if (battle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(battle);
    }
}
