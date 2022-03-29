package com.pokepals.pokemonbackend.pokemon;

import java.util.List;

public interface PokemonDAO {

    List<Pokemon> getAllPokemon();
    Pokemon getPokemonById(Integer id);
    int addPokemon (Pokemon pokemon);
    int deletePokemonById (Integer id);
    List<Pokemon> getAllPokemonByTrainerId (Integer trainerId);

//    int updatePokemonById (Integer id)

}
