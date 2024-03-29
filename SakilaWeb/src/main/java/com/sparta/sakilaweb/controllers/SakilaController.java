package com.sparta.sakilaweb.controllers;

import com.sparta.sakilaweb.entities.Actor;
import com.sparta.sakilaweb.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("castList")
public class SakilaController {
    @Autowired
    private ActorRepository repo;

    @GetMapping("/cast/add/{id}")
    public String addCastMember(@PathVariable int id,
                                Model model,
                                @ModelAttribute("castList") List<Actor> castList){
        Actor actor = repo.findById(id).get();
        castList.add(actor);
//        model.addAttribute("castList", castList);
        System.out.println(castList);
        return "displayCastList";
    }

    @ModelAttribute("castList")
    public List<Actor> castList(){
        return new ArrayList<Actor>();
    }

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

    @GetMapping("/actor/edit/{id}")
    public String displayActorEditForm(@PathVariable int id, Model model){
        Actor actor = repo.findById(id).get();
        model.addAttribute("actorToEdit", actor);
        return "actorEditForm";
    }

    @PostMapping("/updateActor")
    public String updateActor(@ModelAttribute("actorToEdit") Actor actor){
        actor.setLastUpdate(Instant.now());
        System.out.println(actor);
        repo.save(actor);
//        repo.saveAndFlush(actor);
        return "editSuccess";
    }

    @GetMapping("/actor/delete/{id}")
    public String deleteActor(@PathVariable int id){
        repo.delete(repo.findById(id).get());
        return "actorDeleted";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}
