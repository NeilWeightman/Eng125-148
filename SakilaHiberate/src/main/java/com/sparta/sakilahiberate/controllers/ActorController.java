package com.sparta.sakilahiberate.controllers;

import com.sparta.sakilahiberate.entities.ActorEntity;
import com.sparta.sakilahiberate.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    private ActorRepository repo;

    @GetMapping("/actors")
    public List<ActorEntity> getActors(){
        return repo.findAll();
    }

    @GetMapping("/actor/{id}")
    public ActorEntity getById(@PathVariable int id){
        ActorEntity result = repo.findById(id).get();
        return result;
    }

    @DeleteMapping("/actor/{id}/delete")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        ActorEntity result = repo.findById(id).get();
        repo.delete(result);
    }

    @GetMapping("/actor/name/{lastName}")
    public List<ActorEntity> getByLastName(@PathVariable String lastName){
        List<ActorEntity> listOfActors = repo.findByLastName(lastName);
        return listOfActors;
    }
}
