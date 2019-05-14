package org.zenika.api.service;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.zenika.api.client.ArenaApi;
import org.zenika.api.entity.BattleEntity;
import org.zenika.api.entity.Pokemon;
import org.zenika.api.repository.PokemonRepository;
import org.zenika.core.Battle;
import org.zenika.core.BattleStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceUnitTest {

    @InjectMocks
    @Spy
    private PokemonService service;

    @Mock
    private PokemonRepository pokemonRepository;
    @Mock
    private ArenaApi arenaApi;

    private Pokemon mockedPokemon(String name) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setTypes("manager,babyfoot");
        return pokemon;
    }

    @Test
    public void shouldFindPokemonsByName() {
        // Given
        Pokemon pokemon = mockedPokemon("Anthony");
        given(pokemonRepository.findByName(pokemon.getName())).willReturn(Optional.of(pokemon));

        // When
        org.zenika.core.Pokemon foundPokemon = service.getPokemonByIdOrName("Anthony");

        // Then
        verify(pokemonRepository).findByName("Anthony");
        assertEquals("Service should return the pokemon found by Name",
            pokemon.getName(),
            foundPokemon.getName());
    }

    @Test
    public void shouldFindPokemonsById() {
        // Given
        Pokemon pokemon = mockedPokemon("Mathieu");
        given(pokemonRepository.findByName(any())).willReturn(Optional.empty());
        given(pokemonRepository.findById(123L)).willReturn(Optional.of(pokemon));

        // When
        org.zenika.core.Pokemon foundPokemon = service.getPokemonByIdOrName("123");

        // Then
        verify(pokemonRepository).findById(123L);
        assertEquals("Service should return the pokemon found by ID if not found by name",
            pokemon.getName(),
            foundPokemon.getName());
    }

    @Test
    public void shouldNotFindPokemons() {
        // Given
        given(pokemonRepository.findByName(any())).willReturn(Optional.empty());
        given(pokemonRepository.findById(any())).willReturn(Optional.empty());

        // When
        org.zenika.core.Pokemon foundPokemon = service.getPokemonByIdOrName("1234567890");

        // Then
        verify(pokemonRepository).findById(any());
        verify(pokemonRepository).findByName(any());
        assertNull("Service should NOT return the pokemon", foundPokemon);
    }

    @Test
    public void shouldStartAFight() {
        // Given
        BattleEntity battle = new BattleEntity();
        given(arenaApi.fight(any())).willReturn(battle);
        doReturn(mock(org.zenika.core.Pokemon.class)).when(service).getPokemonByIdOrName("Anthony");
        doReturn(mock(org.zenika.core.Pokemon.class)).when(service).getPokemonByIdOrName("Mathieu");

        // When
        Battle fight = service.fight("Anthony", "Mathieu");

        // Then
        assertEquals(BattleStatus.TO_START, fight.getBattleStatus());
    }
}