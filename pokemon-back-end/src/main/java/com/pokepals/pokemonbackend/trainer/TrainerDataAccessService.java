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
    public List<Trainer> getAllTrainers() {

        String sql = """
                SELECT id, name, email, password, sprite_link
                FROM trainer
                """;

        RowMapper<Trainer> trainerRowMapper = (rs, rowNum) -> {  //rowmapper to go through each row, gives you result set, which we then turn into ints, strings etc to make a new car object
            Trainer trainer = new Trainer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("sprite_link")
            );
            return trainer; //so its not lost in the heap
        };

        List<Trainer> trainerList = jdbcTemplate.query(sql, trainerRowMapper);
        if (trainerList.isEmpty()) {
            return null;
        } else {
            return trainerList;
        }
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
        String sql = """
                INSERT INTO trainer (name, email, password, sprite_link)
                VALUES(?, ?, ?, ?)
                """;

        // Use .update Method when Inserting/deleting/updating

        int result = jdbcTemplate.update(
                sql,
                trainer.getName(),
                trainer.getEmail(),
                trainer.getPassword(),
                trainer.getSprite_link()
        );
        return result;
    }


    @Override
    public int deleteTrainerById(Integer id) {
        String sql = "DELETE FROM trainer WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }


    @Override
    public Trainer updateTrainer(Integer trainer_id, Trainer update) {
        return null;
    }
}
