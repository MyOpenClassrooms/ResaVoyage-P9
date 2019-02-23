package com.ms.aventure.controller;


import com.ms.aventure.entity.Aventure;
import com.ms.aventure.repository.AventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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




}
