package org.zenika.api.service

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.zenika.api.client.ArenaApi
import org.zenika.api.entity.BattleEntity
import org.zenika.api.entity.Pokemon
import org.zenika.api.repository.PokemonRepository
import org.zenika.core.BattleStatus
import org.zenika.core.BattleStatus.TO_START
import java.util.Optional

class PokemonServiceUnitTest {

    @InjectMockKs
    private lateinit var service: PokemonService

    @MockK
    private lateinit var pokemonRepository: PokemonRepository
    @MockK
    private lateinit var arenaApi: ArenaApi

    private fun mockedPokemon(name: String): Pokemon {
        return Pokemon(
            id = 123L,
            name = name,
            types = "manager,babyfoot",
            baseExperience = "",
            height = 12,
            isDefault = false,
            order = 1,
            weight = 23
        )
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun shouldFindPokemonsByName() {
        // Given
        val pokemon = mockedPokemon("Anthony")
        every { pokemonRepository.findByName(pokemon.name) } returns pokemon

        // When
        val foundPokemon = service.getPokemonByIdOrName("Anthony")

        // Then
        verify { pokemonRepository.findByName("Anthony") }
        assertEquals(
            "Service should return the pokemon found by Name",
            pokemon.name,
            foundPokemon?.name
        )
    }

    @Test
    fun shouldFindPokemonsById() {
        // Given
        val pokemon = mockedPokemon("Mathieu")
        every { pokemonRepository.findByName(any()) } returns null
        every { pokemonRepository.findById(123L) } returns Optional.of(pokemon)

        // When
        val foundPokemon = service.getPokemonByIdOrName("123")

        // Then
        verify { pokemonRepository.findById(123L) }
        assertEquals(
            "Service should return the pokemon found by ID if not found by name",
            pokemon.name,
            foundPokemon?.name
        )
    }

    @Test
    fun shouldNotFindPokemons() {
        // Given
        every { pokemonRepository.findByName(any()) } returns null
        every { pokemonRepository.findById(any()) } returns Optional.empty()

        // When
        val foundPokemon = service!!.getPokemonByIdOrName("1234567890")

        // Then
        verify {
            pokemonRepository.findById(any())
            pokemonRepository.findByName(any())
        }
        assertNull("Service should NOT return the pokemon", foundPokemon)
    }

    @Test
    fun shouldStartAFight() {
        // Given
        val battle = BattleEntity("0")
        every { arenaApi.fight(any()) } returns battle
        every { service.getPokemonByIdOrName("Anthony") } returns mockk()
        every { service.getPokemonByIdOrName("Mathieu") } returns mockk()

        // When
        val fight = service.fight("Anthony", "Mathieu")

        // Then
        assertEquals("0", fight?.id)
    }
}