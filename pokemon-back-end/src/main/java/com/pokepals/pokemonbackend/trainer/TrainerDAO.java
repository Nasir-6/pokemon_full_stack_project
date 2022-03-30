package com.pokepals.pokemonbackend.trainer;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrainerDAO {


     List<Trainer> getAllTrainers();
     Trainer getTrainerById(Integer id);
     int addTrainer(Trainer trainer);
     int deleteTrainerById(Integer id);
     //extension
     Trainer updateTrainer(Integer trainer_id, Trainer update);




//5. Update Trainer Email (?)
//6. Update Trainer Password (?)


}
