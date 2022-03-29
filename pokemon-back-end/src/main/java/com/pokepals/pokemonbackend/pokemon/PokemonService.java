package com.pokepals.pokemonbackend.pokemon;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    //create a property of pokemonDAO
    private PokemonDAO pokemonDAO;

    //constructor of pokemonDAO
    public PokemonService(@Qualifier("pokemon_postgres") PokemonDAO pokemonDAO) {
        this.pokemonDAO = pokemonDAO;
    }


    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = pokemonDAO.getAllPokemon();
        if (pokemonList == null) {
            throw new IllegalStateException("No pokemon found");
        }
        return pokemonList;
    }

//    Pokemon getPokemonById(Integer id);
    public Pokemon getPokemonById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalStateException("Invalid Pokemon ID");
        }
        Pokemon pokemon = pokemonDAO.getPokemonById(id);
        if (pokemon == null) {
            throw new IllegalStateException("No pokemon found");
        }
        // Return pokemon by ID
        return pokemon;

    }





    //instance of the Pokemon DAO


    //1. Get all Pokemons by Trainer Id
    //Using a List
    //length/size of list == 0 then no pokemons
    //illegal state exception

    //2. Add Pokemon
    //if statement to check if the id is already in the database
    // but if the exists - you already have this pokemon, don't catch!

    //3. Delete Pokemons by Id
//if statement - check if (PokemonDAO.selectPokemonById == null))
    //exception - pokemon is not there
    // else return the pokemon to be deleted (by Id)


    //4. Update Pokemon (Extension)
    //update HP
    //update Level
//if statement - to check if  the pokemon is there (PokemonDAO.selectPokemonById != null)
    //else exception - pokemon is not there


}
