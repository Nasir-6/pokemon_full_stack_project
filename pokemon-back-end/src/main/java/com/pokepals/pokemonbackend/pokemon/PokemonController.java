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

    // addpokemon
    @PostMapping(path = "pokemon")
    public int addPokemon (@RequestBody Pokemon pokemon){
        return pokemonService.addPokemon(pokemon);
    }

    @GetMapping(path = "pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Integer id) {
        return pokemonService.getPokemonById(id);
    }

    //deleting
    @DeleteMapping(path = "pokemon/{id}")
    public int deletePokemonbyId(@PathVariable ("id") Integer id) {
        return pokemonService.deletePokemonById(id);
    }

     // getting all the pokemons for one trainer by using the trainer id
    @GetMapping(path ="pokemon/trainer/{trainerId}")
    public List <Pokemon> getAllPokemonByTrainerId (@PathVariable("trainerId") Integer trainerId) {
        return pokemonService.getAllPokemonByTrainerId(trainerId);
    }


    }
