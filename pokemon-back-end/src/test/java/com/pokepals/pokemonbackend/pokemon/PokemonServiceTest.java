package com.pokepals.pokemonbackend.pokemon;

import com.pokepals.pokemonbackend.trainer.Trainer;
import com.pokepals.pokemonbackend.trainer.TrainerDAO;
import com.pokepals.pokemonbackend.trainer.TrainerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class PokemonServiceTest {
    private PokemonService underTest;
    private PokemonDAO pokemonDAO;

    @BeforeEach
    void setUp() {
        this.pokemonDAO = Mockito.mock(PokemonDAO.class);
        this.underTest = new PokemonService(pokemonDAO);
    }

    @Test
    void canGetAllPokemon() {
        // Given
        Pokemon testPokemon1 = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        Pokemon testPokemon2 = new Pokemon(2, 1, "pokemon2", 4, "https://pokemon/4.png", 85, 4);
        Pokemon testPokemon3 = new Pokemon(3, 2, "pokemon3", 5, "https://pokemon/5.png", 123, 7);
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(testPokemon1);
        pokemonList.add(testPokemon2);
        pokemonList.add(testPokemon3);
        given(pokemonDAO.getAllPokemon()).willReturn(pokemonList);
        // When
        List<Pokemon> actual = underTest.getAllPokemon();
        // Then
        List<Pokemon> expected = pokemonList;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowWhenPokemonDbIsEmpty() {
        // Given
        given(pokemonDAO.getAllPokemon()).willReturn(null);
        // When
        assertThatThrownBy(() -> underTest.getAllPokemon())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("No pokemon found");
        // Then
        // verify(pokemonDAO, never()).getAllPokemon();
    }

    @Test
    void canGetPokemonById() {
        // Given
        Pokemon testPokemon = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        given(pokemonDAO.getPokemonById(1)).willReturn(testPokemon);
        // When
        Pokemon actual = underTest.getPokemonById(1);
        // Then
        Pokemon expected = testPokemon;
        assertThat(actual).isEqualTo(expected);
    }
    // Test all getPokemonById scenarios here ^

    @Test
    void canAddPokemon() {
        // Given
        Pokemon testPokemon = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        given(pokemonDAO.addPokemon(testPokemon)).willReturn(1);
        // When
        Integer actual = underTest.addPokemon(testPokemon);
        // Then
        Integer expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canDeletePokemonById() {
        // Given
        int id = 1;
        Pokemon testPokemon = new Pokemon(id, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);

        // This will ensure pokemonInDb is not null
        given(pokemonDAO.getPokemonById(id)).willReturn(testPokemon);
        // This one will mock the deletPersonById to return 1 ONLY when passing in id of 1
        // (so if id changes to something else it will return null by default)
        given(pokemonDAO.deletePokemonById(id)).willReturn(1);
        // When
        int actual = underTest.deletePokemonById(id);
        // Then
        int expected = 1;
        assertThat(actual).isEqualTo(expected);

    }

//    @Test
//    void getAllPokemonByTrainerId() {
//    }

}