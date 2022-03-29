package com.pokepals.pokemonbackend.trainer;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "trainer")
    public Trainer addPerson(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }



//    Trainer getTrainerById(Integer id);
//    int addTrainer(Trainer trainer);
//    int deleteTrainerById(Integer id);
//    //extension
//    List<Trainer> getAllTrainer();
//    Trainer updateTrainer(Integer trainer_id, Trainer update)


}
