package com.pokepals.pokemonbackend.pokemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {
    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    
    @GetMapping(path = "pokemon")
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping(path = "pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Integer id) { return pokemonService.getPokemonById(id); }

    }
