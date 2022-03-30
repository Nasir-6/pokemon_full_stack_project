package com.pokepals.pokemonbackend.trainer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(path = "trainer")
    public List<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping(path = "trainer/{id}")
    public Trainer getTrainerById(@PathVariable("id") Integer id){
        return trainerService.getTrainerById(id);
    }

    @PostMapping(path = "trainer")
    public Trainer addPerson(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @DeleteMapping(path = "trainer/{id}")
    public int deleteTrainerById(@PathVariable("id") Integer id){
        return trainerService.deleteTrainerById(id);
    }

    @GetMapping(path = "trainer/login")
    public Trainer getTrainerIfPasswordIsCorrect(@RequestBody Trainer trainerDetails){
        return trainerService.getTrainerIfPasswordIsCorrect(trainerDetails);
    }

//    //extension
//    Trainer updateTrainer(Integer trainer_id, Trainer update)


}
