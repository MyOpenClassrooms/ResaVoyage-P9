package com.ms.commentaire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.commentaire.model.Commentaire;
import com.ms.commentaire.repository.CommentaireDao;

@RestController
public class CommentaireController {
	
	@Autowired
    CommentaireDao comDao;
	
	@GetMapping(value = "/comments/{idaventure}")
    public List<Commentaire> listbyidaventure(@PathVariable Long idaventure) {
        
        List<Commentaire> comments = new ArrayList<>();
        comments.add(comDao.findByIdaventure(idaventure));
        return comments;
    }

	@PostMapping(value = "/commentaire/save")
    public void save(@RequestBody Commentaire comment) {
        comDao.save(comment);
    }
}
