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

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
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
    void canGetPokemonById() {
        // Given
        Pokemon testPokemon1 = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        Pokemon testPokemon2 = new Pokemon(2, 1, "pokemon2", 4, "https://pokemon/4.png", 85, 4);
        Pokemon testPokemon3 = new Pokemon(3, 2, "pokemon3", 5, "https://pokemon/5.png", 123, 7);
        List<Pokemon> allPokemonById = new ArrayList<>();
        allPokemonById.add(testPokemon1);
        allPokemonById.add(testPokemon2);
        allPokemonById.add(testPokemon3);
        given(pokemonDAO.getPokemonById(2)).willReturn(testPokemon2);
        // When
        Pokemon actual = underTest.getPokemonById(2);
        // Then
        Pokemon expected = testPokemon2;
        assertThat(actual).isEqualTo(expected);
    }

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
        Pokemon testPokemon = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        given(pokemonDAO.deletePokemonById(id)).willReturn(0);
        given(pokemonDAO.getPokemonById(id)).willReturn(testPokemon);
        // When
        int actual = underTest.deletePokemonById(id);
        ArgumentCaptor<Integer> pokemonArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(pokemonDAO).deletePokemonById(pokemonArgumentCaptor.capture());
        Integer expected = pokemonArgumentCaptor.getValue();
        // Then
        assertThat(expected).isEqualTo(id);
        assertThat(actual).isEqualTo(0);
    }

//    @Test
//    void getAllPokemonByTrainerId() {
//    }
}