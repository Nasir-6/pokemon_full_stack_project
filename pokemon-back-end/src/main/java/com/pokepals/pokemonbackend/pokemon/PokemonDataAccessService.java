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
        String sql = """
                SELECT id, trainer_id, name, pokeapi_id, sprite_link, hp, level 
                FROM pokedex
                """;
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
        String sql = """
                SELECT id, trainer_id, name, pokeapi_id, sprite_link, hp, level 
                FROM pokedex WHERE id = ?
                """;
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
        String sql = """
                INSERT INTO pokedex (SELECT id, trainer_id, name, pokeapi_id, sprite_link, hp, level)
                VALUES(?, ?, ?, ?, ?, ?, ?)
                """;
        // Use .update Method when Inserting/deleting/updating

//        int result -
//                pokemon.getId(),
//        int result = jdbcTemplate.update(
//                insertSql,
//                appointment.getPatientNhsId(),
//                appointment.getDoctorId(),
//                appointment.getAppointmentDate().toString(),
//                appointment.getAppointmentTime().toString()
//        );
//        return result;
    }



    }



    @Override
    public int deletePokemonById(Integer id) {
        return 0;
    }

    @Override
    public List<Pokemon> getAllPokemonByTrainerId(Integer trainerId) {
        return null;
    }

}

