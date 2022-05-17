package com.pokepals.pokemonbackend.pokemon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("pokemon_postgres")
public class PokemonDataAccessService implements PokemonDAO {
        private JdbcTemplate jdbcTemplate;

    public PokemonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Pokemon> getAllPokemon() {
        String sql =
                "SELECT id, trainer_id, name, pokeapi_id, sprite_link, hp, level" +
                " FROM pokedex";
        RowMapper<Pokemon> pokemonRowMapper = (rs, rowNum) -> {
            Pokemon pokemon = new Pokemon(
                    rs.getInt("id"),
                    rs.getInt("trainer_id"),
                    rs.getString("name"),
                    rs.getInt("pokeapi_id"),
                    rs.getString("sprite_link"),
                    rs.getInt("hp"),
                    rs.getInt("level")
            );
            return pokemon;
        };

        List<Pokemon> pokemonList = jdbcTemplate.query(sql, pokemonRowMapper);
        if (pokemonList.isEmpty()) {
            return null;
        } else {
            return pokemonList;
        }
    }


    @Override
    public Pokemon getPokemonById(Integer id) {
        String sql = "SELECT id, trainer_id, name, pokeapi_id, sprite_link, hp, level" +
                " FROM pokedex WHERE id = ?";
        RowMapper<Pokemon> pokemonRowMapper = (rs, rowNum) -> {
            return new Pokemon(
                    rs.getInt("id"),
                    rs.getInt("trainer_id"),
                    rs.getString("name"),
                    rs.getInt("pokeapi_id"),
                    rs.getString("sprite_link"),
                    rs.getInt("hp"),
                    rs.getInt("level")
            );
        };

        List<Pokemon> pokemonList = jdbcTemplate.query(sql, pokemonRowMapper, id);
        if (pokemonList.isEmpty()) {
            return null;
        } else {
            return pokemonList.get(0);
        }
    }



    @Override
    public int addPokemon(Pokemon pokemon) {

        String sql =
                "INSERT INTO pokedex (trainer_id, name, pokeapi_id, sprite_link, hp, level)" +
                " VALUES(?, ?, ?, ?, ?, ?)";

        // Use .update Method when Inserting/deleting/updating

        int result = jdbcTemplate.update(
                sql,
                pokemon.getTrainer_id(),
                pokemon.getName(),
                pokemon.getPokeapi_id(),
                pokemon.getSprite_link(),
                pokemon.getHp(),
                pokemon.getLevel()
        );
        return result;
    }

    @Override
    public int deletePokemonById (Integer id) {
        String sql = "DELETE FROM pokedex WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }
    @Override
    public List <Pokemon> getAllPokemonByTrainerId (Integer trainerId) {
        String sql =
                "SELECT id, trainer_id, name, pokeapi_id, sprite_link, hp, level" +
                " FROM pokedex WHERE trainer_id = ?";

        RowMapper<Pokemon> pokemonRowMapper = (rs, rowNum) -> {
            Pokemon onePokemon = new Pokemon(
                    rs.getInt("id"),
                    rs.getInt("trainer_id"),
                    rs.getString("name"),
                    rs.getInt("pokeapi_id"),
                    rs.getString("sprite_link"),
                    rs.getInt("hp"),
                    rs.getInt("level")
            );
            return onePokemon;
        };

        List<Pokemon> pokemonList = jdbcTemplate.query(sql, pokemonRowMapper, trainerId);
        if (pokemonList.isEmpty()) {
            return null;
        } else {
            return pokemonList;
        }
    }
}








