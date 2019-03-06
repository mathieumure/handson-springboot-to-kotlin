package org.zenika.arena.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zenika.arena.entity.BattleEntity;
import org.zenika.arena.service.ArenaService;
import org.zenika.core.BattleStatus;
import org.zenika.core.Pokemon;

import java.util.List;

@RestController
@RequestMapping("/fight")
public class FightController {

    private ArenaService arenaService;

    public FightController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @PostMapping
    public ResponseEntity fight(@RequestBody List<Pokemon> pokemons) {
        if (pokemons.size() != 2) {
            return ResponseEntity.badRequest().body("This is a traditional sport!!! Only 2 pokemons can have a fight");
        }
        return ResponseEntity.ok(arenaService.startFight(pokemons));
    }

    @GetMapping("/{id}")
    public BattleEntity get(@PathVariable String id) {
        return arenaService.getBattle(id);
    }

    @GetMapping("/{id}/status")
    public BattleStatus getStatus(@PathVariable String id) {
        return arenaService.getBattleStatus(id);
    }

}
