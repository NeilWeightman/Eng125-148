package com.sparta.sakilaweb.controller;

import com.sparta.sakilaweb.entities.Actor;
import com.sparta.sakilaweb.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.Optional;

@Controller
public class SakilaController {
    @Autowired
    private ActorRepository repo;

    @GetMapping("/welcome")
    public String sayHello(){
        return "../static/welcome.html";
    }

    @GetMapping("/getTime")
    public String getTime(Model model){
        model.addAttribute("currentTime", new Date());
        return "gettime";
    }

    @GetMapping("/actor/{id}")
    public String getActor(@PathVariable int id, Model model){
        Optional<Actor> result = repo.findById(id);
        Actor actor = null;
        if(result.isPresent())
            actor = result.get();
        model.addAttribute("actor", actor);
        return "displayActor";
    }

//    @GetMapping("/actor/{id}")
//    public String getActor(@PathVariable int id, Model model){
//        Optional<Actor> result = repo.findById(id);
//        Actor actor = null;
//        if(result.isPresent())
//            actor = result.get();
//        if(actor != null){
//            model.addAttribute("actor", actor);
//            return "displayActor";
//        } else
//            return "noActorFound";
//    }
}
