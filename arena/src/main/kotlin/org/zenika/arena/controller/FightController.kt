package org.zenika.arena.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.zenika.arena.entity.BattleEntity
import org.zenika.arena.service.ArenaService
import org.zenika.core.BattleStatus
import org.zenika.core.Pokemon

@RestController
@RequestMapping("/fight")
class FightController(val arenaService: ArenaService) {

    @PostMapping
    fun fight(@RequestBody pokemons: List<Pokemon> ): ResponseEntity<Any> =
        if (pokemons.size != 2) {
            ResponseEntity.badRequest().body("This is a traditional sport!!! Only 2 pokemons can have a fight")
        } else {
            ResponseEntity.ok(arenaService.startFight(pokemons))
        }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): BattleEntity = arenaService.getBattle(id)

    @GetMapping("/{id}/status")
    fun getStatus(@PathVariable id: String): BattleStatus? = arenaService.getBattleStatus(id)

}
