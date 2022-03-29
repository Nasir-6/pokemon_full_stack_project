package com.pokepals.pokemonbackend.trainer;


import com.pokepals.pokemonbackend.pokemon.Pokemon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("trainer_postgres")
public class TrainerDataAccessService implements TrainerDAO{
    private JdbcTemplate jdbcTemplate;

    public TrainerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Trainer getTrainerById(Integer id) {
        String sql = """
                SELECT id, name, email, password, sprite_link 
                FROM trainer WHERE id = ?
                """;
        RowMapper<Trainer> trainerRowMapper = (rs, rowNum) -> {
            return new Trainer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("sprite_link")

            );
        };
        //we will store one trainer in the list - expect 1 only (or null if fails)
        //thus get(0) will get the index 0 will return that one person not list
        List<Trainer> trainerList = jdbcTemplate.query(sql, trainerRowMapper, id);
        if (trainerList.isEmpty()) {
            return null;
        } else {
            return trainerList.get(0);
        }
    }


    @Override
    public int addTrainer(Trainer trainer) {
        return 0;
    }

    @Override
    public int deleteTrainerById(Integer id) {
        return 0;
    }

    @Override
    public List<Trainer> getAllTrainer() {
        return null;
    }

    @Override
    public Trainer updateTrainer(Integer trainer_id, Trainer update) {
        return null;
    }
}
