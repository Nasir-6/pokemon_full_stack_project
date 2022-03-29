package com.pokepals.pokemonbackend.pokemon;

import java.util.List;

public interface PokemonDAO {

    List<Pokemon> getAllPokemon();
    List<Pokemon> selectAllPokemonById(Integer id);
    int addPokemon (Pokemon pokemon);
    int deletePokemonById (Integer id);

//    int updatePokemonById (Integer id)

}
