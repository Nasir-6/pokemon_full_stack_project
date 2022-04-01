package com.pokepals.pokemonbackend.pokemon;

import com.pokepals.pokemonbackend.trainer.Trainer;
import com.pokepals.pokemonbackend.trainer.TrainerDAO;
import com.pokepals.pokemonbackend.trainer.TrainerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

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
        Pokemon pokemon1 = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        Pokemon pokemon2 = new Pokemon(2, 1, "pokemon2", 4, "https://pokemon/4.png", 85, 4);
        Pokemon pokemon3 = new Pokemon(3, 2, "pokemon3", 5, "https://pokemon/5.png", 123, 7);
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
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
        Pokemon pokemon1 = new Pokemon(1, 1, "pokemon1", 1, "https://pokemon/1.png", 100, 5);
        Pokemon pokemon2 = new Pokemon(2, 1, "pokemon2", 4, "https://pokemon/4.png", 85, 4);
        Pokemon pokemon3 = new Pokemon(3, 2, "pokemon3", 5, "https://pokemon/5.png", 123, 7);
        List<Pokemon> allPokemonById = new ArrayList<>();
        allPokemonById.add(pokemon1);
        allPokemonById.add(pokemon2);
        allPokemonById.add(pokemon3);
        given(pokemonDAO.getPokemonById(2)).willReturn(pokemon2);
        // When
        Pokemon actual = underTest.getPokemonById(2);
        // Then
        Pokemon expected = pokemon2;
        assertThat(actual).isEqualTo(expected);
    }

//    @Test
//    void addPokemon() {
//    }
//
//    @Test
//    void deletePokemonById() {
//    }
//
//    @Test
//    void getAllPokemonByTrainerId() {
//    }
}