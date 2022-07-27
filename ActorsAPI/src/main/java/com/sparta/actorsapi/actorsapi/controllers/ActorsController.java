package com.sparta.actorsapi.actorsapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.actorsapi.actorsapi.dataobcjects.Actor;
import com.sparta.actorsapi.actorsapi.services.SakilaActorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorsController {

    @Autowired
    private SakilaActorDAO dao;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/actors/{id}")
    public Actor actorDetails(@PathVariable String id){
        int actor_id = 0;
        try{
            actor_id = Integer.parseInt(id);
        } catch(NumberFormatException e){
            actor_id = 1;
        }
        return dao.getActor(actor_id);
    }

    @GetMapping("/actors")
    public Actor getActorParam(@RequestParam int actor_id){
        return dao.getActor(actor_id);
    }

    @GetMapping("actors/{fname}/{lname}")
    public ResponseEntity<String> getActorByName(@PathVariable String fname, @PathVariable String lname){

        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        Actor result = dao.getActor(fname, lname);
        System.out.println(result);
        try {
            return new ResponseEntity<String>(mapper.writeValueAsString(result),
                    headers, HttpStatus.I_AM_A_TEAPOT);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return new ResponseEntity<String>("{\"message\":\"JSON processing failed\"}",
                    headers, HttpStatus.OK);
        }
    }

    @GetMapping("/actorsAll")
    public List<Actor> getAllActors(){
        return dao.getAllActors();
    }

    @PostMapping("/newActor")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void insertActor(@RequestBody Actor newActor){
        System.out.println(newActor);
        dao.addActor(newActor);
    }
}
