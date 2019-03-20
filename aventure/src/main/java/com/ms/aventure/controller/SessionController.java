package com.ms.aventure.controller;

import com.ms.aventure.entity.Aventure;
import com.ms.aventure.entity.Session;
import com.ms.aventure.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SessionController {

    @Autowired
    private SessionRepository repository;


    @RequestMapping(value = "/session/getAll/{aventureId}", method = RequestMethod.GET)
    public List<Session> getAllSessionsByAventureId(@PathVariable Integer aventureId) throws Exception {
        List<Session> sessions = new ArrayList<>(repository.findAllByAventureId(aventureId));
        if (sessions.isEmpty()){
            throw new Exception("Il n'existe aucune session avec l'id : " + aventureId);
        }
        return sessions;
    }


    @GetMapping(value = "/session/{sessionId}")
    public Session findById(@PathVariable Integer sessionId) {
        return repository.getOne(sessionId);
    }



}
