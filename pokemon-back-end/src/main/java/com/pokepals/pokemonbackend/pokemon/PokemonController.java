package com.pokepals.pokemonbackend.pokemon;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {
    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //all pokemons
    @GetMapping(path = "pokemon")
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping(path = "pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Integer id) { return pokemonService.getPokemonById(id); }


    //deleting
    @DeleteMapping(path = "pokemon/{id}")
    public void deletePokemonbyId(@PathVariable ("id") Integer id) {
        pokemonService.deletePokemonById(id);
    }
     // getting all the pokemons for one trainer by using the trainer id
    @GetMapping(path ="AllPokemon/{trainerId}")
    public List <Pokemon> getAllPokemonByTrainerId (@PathVariable("trainerId") Integer trainerId) {
        return pokemonService.getAllPokemonByTrainerId(trainerId);
    }


    }
