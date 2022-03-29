package com.pokepals.pokemonbackend.trainer;

import com.pokepals.pokemonbackend.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainerService {

    //property of trainerService
    private TrainerDAO trainerDAO;

    //creates an instance passing the trainerDAO
    public TrainerService(@Qualifier("trainer_postgres")TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    public Trainer getTrainerById(Integer id) {
        if (id == null || id <= 0){
            throw new IllegalStateException("Trainer ID invalid");
        }

        Trainer trainer = trainerDAO.getTrainerById(id);

        if (trainer == null) {
            throw new IllegalStateException("Trainer not found");
        }

        return trainer;
    }

    public Trainer addTrainer(Trainer trainer) {
        checkTrainerInputs(trainer);
        int result = trainerDAO.addTrainer(trainer);
        if (result == 0) {
            throw new IllegalStateException("Unable to add to database");
        }
        return trainer;
    }

    private void checkTrainerInputs(Trainer trainer) {
        if (trainer.getName() == null) {
            throw new IllegalStateException("Trainer name cannot be null");
        } else if (trainer.getEmail() == null) {
            throw new IllegalStateException("Trainer email cannot be null");
        } else if (trainer.getPassword() == null) {
            throw new IllegalStateException("Trainer password cannot be null");
        } else if (trainer.getSprite_link() == null) {
            throw new IllegalStateException("Trainer sprite cannot be null");
        }
        // Add exception for email validation (and password?)
        // Also, sprite link needs to be a valid link
    }




//    int addTrainer(Trainer trainer);
//    int deleteTrainerById(Integer id);
//    //extension
//    List<Trainer> getAllTrainer();
//    Trainer updateTrainer(Integer trainer_id, Trainer update);









}
