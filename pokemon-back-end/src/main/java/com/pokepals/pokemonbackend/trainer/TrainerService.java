package com.pokepals.pokemonbackend.trainer;

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




//    int addTrainer(Trainer trainer);
//    int deleteTrainerById(Integer id);
//    //extension
//    List<Trainer> getAllTrainer();
//    Trainer updateTrainer(Integer trainer_id, Trainer update);









}
