package com.pokepals.pokemonbackend.trainer;

import com.pokepals.pokemonbackend.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    //property of trainerService
    private TrainerDAO trainerDAO;

    //creates an instance passing the trainerDAO
    public TrainerService(@Qualifier("trainer_postgres")TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }


    public List<Trainer> getAllTrainers(){
        return trainerDAO.getAllTrainers();
    }

    public Trainer getTrainerById(Integer id) {
        if (id == null) {
            throw new IllegalStateException("ID cannot be null");
        } else if (id <= 0) {
            throw new IllegalStateException("ID cannot be less than or equal to 0");
        }

        Trainer trainer = trainerDAO.getTrainerById(id);
        if (trainer == null) {
            throw new IllegalStateException("Trainer not found");
        }
        return trainer;
    }


    //This is used for checking if trainer with email
    private Trainer getTrainerByEmail(String email){
        List<Trainer> allTrainersInDb = trainerDAO.getAllTrainers();
        for (Trainer trainer : allTrainersInDb) {
            if (trainer.getEmail().equals(email)) {
                return trainer;
            }
        }
        return null;
    }

    public Trainer addTrainer(Trainer trainer) {
        checkTrainerInputs(trainer);

        // Verify trainer with same email doesn't exist in DB
        Trainer trainerInDb = getTrainerByEmail(trainer.getEmail());
        if(trainerInDb != null){
            // Found someone in db with email already
            throw new IllegalStateException("Trainer with same email already exists");
        }

        int result = trainerDAO.addTrainer(trainer);
        if (result == 0) {
            throw new IllegalStateException("Unable to add to database");
        }

        // Return the new trainer in DB for use after Post Request
        return getTrainerByEmail(trainer.getEmail());
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

    public int deleteTrainerById(Integer id) {
        if (id == null) {
            throw new IllegalStateException("ID cannot be null");
        } else if (id <= 0) {
            throw new IllegalStateException("ID cannot be less than or equal to 0");
        }

        Trainer trainerInDb = trainerDAO.getTrainerById(id);
        if (trainerInDb == null) {
            throw new IllegalStateException("This Trainer ID does not exist in database");
        }

        int result = trainerDAO.deleteTrainerById(id);
        if (result !=1) {
            throw new IllegalStateException("Unable to delete Trainer");
        }
        return result;
    }


    public Trainer getTrainerIfPasswordIsCorrect(Trainer trainerDetails){
        if(trainerDetails.getEmail() == null){
            throw new IllegalStateException("Email cannot be null");
        } else if(trainerDetails.getPassword() == null){
            throw new IllegalStateException("Password cannot be null");
        }

        // Use get TrainerBy Email here NO need for DAO
        Trainer trainerInDbWithEmail = getTrainerByEmail(trainerDetails.getEmail());
        if(trainerInDbWithEmail == null){
            throw new IllegalStateException("Trainer with this email does not exist in the DB");
        }
        // Got someone with email - now check if the password matches
        if (trainerInDbWithEmail.getPassword().equals(trainerDetails.getPassword())){
            // Return the whole trainer, id, and all - so we can use as current user in the front-end
            // (We don't want to have the password though!!!! - security issue!!)
            return trainerInDbWithEmail;
        }
        // Else return null - IF NOT GETTING NULL - maybe returning 1 - bear that in mind
        return null;
    }




//    //extension
//    Trainer updateTrainer(Integer trainer_id, Trainer update);









}
