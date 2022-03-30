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

        if (id == null) {
            throw new IllegalStateException("ID cannot be null");
        } else if (id <= 0) {
            throw new IllegalStateException("ID cannot be less than or equal to 0");
        }

        Pokemon pokemon = pokemonDAO.getPokemonById(id);
        if (pokemon == null) {
            throw new IllegalStateException("No pokemon found in DB");
        }
        // Return pokemon by ID
        return pokemon;
    }


    private void checkPokemonInputs(Pokemon pokemon) {
        if(pokemon.getTrainer_id() == null  ) {
            throw new IllegalStateException("Trainer id cannot be null");

        } else if(pokemon.getTrainer_id() <= 0 ) {
            throw new IllegalStateException("Trainer id cannot be less than or equal to 0");

        } else if(pokemon.getName() == null ) {
            throw new IllegalStateException("Pokemon name can not be null");

        } else if(pokemon.getPokeapi_id() == null) {
            throw new IllegalStateException("Pokemon API id cannot be null");

        } else if(pokemon.getPokeapi_id() <= 0) {
            throw new IllegalStateException("Pokemon API id cannot be less than or equal to 0");

        } else if(pokemon.getSprite_link() == null) {
            throw new IllegalStateException("Pokemon sprite Link cannot be null");

        } else if(pokemon.getHp () == null) {
            throw new IllegalStateException("Pokemon Hp cannot be null");

        }else if(pokemon.getHp () <= 0) {
            throw new IllegalStateException("Pokemon Hp cannot be less than or equal to 0");

        }else if(pokemon.getLevel () == null) {
            throw new IllegalStateException("Pokemon level cannot be null");

        } else if(pokemon.getLevel () <= 0) {
            throw new IllegalStateException("Pokemon level cannot be less than or equal to 0");
        }
    }

    public int addPokemon (Pokemon pokemon) {
        //check if all value inputs are correct
        checkPokemonInputs(pokemon);

        //NO need to check if pokemon already exists or not - as can catch more than one


        if (pokemonDAO.addPokemon(pokemon) != 1) {
            throw new IllegalStateException("Could not add pokemon");
        }
        else {
            return 1;
        }
    }

    public int deletePokemonById (Integer id) {
        if (id == null) {
            throw new IllegalStateException("ID cannot be null");
        } else if (id <= 0) {
            throw new IllegalStateException("ID cannot be less than or equal to 0");
        }

        //check if PokemonById exists, so check if null
          if (pokemonDAO.getPokemonById(id) == null ) {
              throw new IllegalStateException("Sorry Pokemon with " + id + " could not be found in DB");
        }
        // otherwise delete Pokemon
        return pokemonDAO.deletePokemonById(id);
    }


       //List<Pokemon> getAllPokemonByTrainerId (Integer trainerId);

    public List <Pokemon> getAllPokemonByTrainerId (Integer trainerId) {

        if (trainerId == null) {
            throw new IllegalStateException("ID cannot be null");
        } else if (trainerId <= 0) {
            throw new IllegalStateException("ID cannot be less than or equal to 0");
        }

        List<Pokemon> pokemonList = pokemonDAO.getAllPokemonByTrainerId(trainerId);
        if (pokemonList == null) {
            throw new IllegalStateException("No pokemon found in db for trainer with id " + trainerId);
        }
        return pokemonList;
    }


    //4. Update Pokemon (Extension)
    //update HP
    //update Level
//if statement - to check if  the pokemon is there (PokemonDAO.selectPokemonById != null)
    //else exception - pokemon is not there


}
