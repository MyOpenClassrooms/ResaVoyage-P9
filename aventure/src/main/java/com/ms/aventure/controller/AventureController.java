package com.ms.aventure.controller;


import com.ms.aventure.entity.Aventure;
import com.ms.aventure.entity.Session;
import com.ms.aventure.repository.AventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AventureController {

    @Autowired
    AventureRepository repository;

   
    @RequestMapping(value = "/aventure/getAll", method = RequestMethod.GET)
    public List<Aventure> getAllAventures(){
        return repository.findAll();
    }

    @GetMapping(value = "/aventure/{id}")
    public Aventure findById(@PathVariable Integer id) {
        return repository.getOne(id);
    }
    
//    @RequestMapping(value = "/getBySession/{sessionId}", method = RequestMethod.GET)
//    public Aventure getAventureBySession(@PathVariable Integer sessionId) throws Exception {
//    	Aventure aventure = repository.findAventureBySessionId(sessionId);
//        if (aventure == null){
//            throw new Exception("Il n'existe aucune aventure avec l'id de session: " + sessionId);
//        }
//        return aventure;
//    }



}
