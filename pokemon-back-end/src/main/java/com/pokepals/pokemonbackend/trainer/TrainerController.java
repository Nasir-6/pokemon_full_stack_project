package com.pokepals.pokemonbackend.trainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(path = "trainer/{id}")
    public Trainer getTrainerById(@PathVariable("id") Integer id){
        return trainerService.getTrainerById(id);
    }





//    Trainer getTrainerById(Integer id);
//    int addTrainer(Trainer trainer);
//    int deleteTrainerById(Integer id);
//    //extension
//    List<Trainer> getAllTrainer();
//    Trainer updateTrainer(Integer trainer_id, Trainer update)


}
