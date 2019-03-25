package org.zenika.core

import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PokemonUtilsTest {

    @Test
    fun `poison attacks must  be effective on grass`() {
        // Given
        val attacker = mockk<Pokemon>()
        val defender = mockk<Pokemon>()
        val picker = { pokemone: Pokemon ->
            if (pokemone == attacker) PokemonType.POISON
            else PokemonType.GRASS
        }

        // When
        val attackResult = PokemonUtils.getAttackResult(attacker, defender, picker)

        // Then
        assertEquals(VERY_EFFECTIVE, attackResult, "Poison attacks must be very effective on Grass pokemons.")
    }
}