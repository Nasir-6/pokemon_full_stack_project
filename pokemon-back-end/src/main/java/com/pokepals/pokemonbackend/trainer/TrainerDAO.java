package com.pokepals.pokemonbackend.trainer;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrainerDAO {



     Trainer getTrainerById(Integer id);
     int addTrainer(Trainer trainer);
     int deleteTrainerById(Integer id);
     //extension
     List<Trainer> getAllTrainer();
     Trainer updateTrainer(Integer trainer_id, Trainer update);







//1.Verification of Email
// 2. Verification of Password

//3. Select all Trainer (?)
//4. Add a Trainer (addTrainerById)
    //check if the email is already in the database
    //exception for trainer already in the database
    // if not, add in the new trainer

//5. Update Trainer Email (?)


//6. Update Trainer Password (?)


//6. Delete Trainer (deleteTrainerById)
}
