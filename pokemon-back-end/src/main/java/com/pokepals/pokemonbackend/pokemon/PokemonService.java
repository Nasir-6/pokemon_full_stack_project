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

    private void checkPokemonProperties(Pokemon pokemon) {
        if(pokemon.getId() <= 0) {
            throw new IllegalStateException("Pokemon id cannot be less than or equal to 0");
        }
        if(pokemon.getTrainer_id() <= 0 ) {
            throw new IllegalStateException("Trainer id cannot be less than or equal to 0");
        }
        if(pokemon.getName()== null ) {
            throw new IllegalStateException("Pokemon name can not be null");
        }
        if(pokemon.getPokeapi_id() <= 0) {
            throw new IllegalStateException("Pokemon id cannot be less than or equal to 0");
        }
        if(pokemon.getSprite_link() == null) {
            throw new IllegalStateException("Pokemon id cannot be less than or equal to 0");
        }
        if(pokemon.getHp () <= 0) {
            throw new IllegalStateException("Pokemon id cannot be less than or equal to 0");
        }
        if(pokemon.getLevel () <= 0) {
            throw new IllegalStateException("Pokemon id cannot be less than or equal to 0");
        }
    }

    public int addPokemon (Pokemon pokemon) {
        //check if all value inputs are correct
        checkPokemonProperties(pokemon);
        //check if pokemon already exists or not

        //Should be a specific value for when booking an important, maybe the method returns the number 1
        // for a completed booking on the system
        if (pokemonDAO.addPokemon(pokemon) != 1) {
            //if it doesn't equal to one throw an exception, but keep the user in the loop to re-add the booking
            throw new IllegalStateException("Could not add pokemon");
        }
        else {
            return 1;
        }
    }

    public int deletePokemonById (Integer id) {

        //check if PokemonById exists, so check if null
          if (pokemonDAO.getPokemonById(id) == null ) {
              throw new IllegalStateException("Sorry Pokemon " + id + " could not be found");
        }
        // otherwise delete Pokemon
        return pokemonDAO.deletePokemonById(id);
    }


       //List<Pokemon> getAllPokemonByTrainerId (Integer trainerId);

    public List <Pokemon> getAllPokemonByTrainerId (Integer trainerId) {
        List<Pokemon> pokemonList = pokemonDAO.getAllPokemonByTrainerId(trainerId);
        if (pokemonList == null) {
            throw new IllegalStateException("No pokemon found by trainer id ");
        }
        return pokemonList;
    }













// comments
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
