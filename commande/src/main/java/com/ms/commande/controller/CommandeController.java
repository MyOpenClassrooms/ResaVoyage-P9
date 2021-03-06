package com.ms.commande.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ms.commande.exception.CommandeIntrouvableException;
import com.ms.commande.model.Commande;
import com.ms.commande.repository.CommandeRepository;
 
@RestController
public class CommandeController {
	 Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CommandeRepository repository;
	
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Commande> findAll(){
		 log.info("Récupération de la liste des commandes");
		 return repository.findAll();
	}
    
    @GetMapping(value = "/findCommandById/{id}")
    public Commande findById(@PathVariable Integer id) {
    	Commande commande = repository.findById(id);
    	if(commande==null) throw new CommandeIntrouvableException("La commande avec l'id " + id +
    			" est INTROUVABLE");
    	 
        return commande;
    }
	
    @PostMapping (value = "/save")
    public ResponseEntity<Void> saveCommande(@RequestBody Commande commande) {
    	Commande commandAdded = repository.save(commande);
    	
        if (commandAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(commandAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    
    @PutMapping (value = "/update/{id}")
    public Commande updateCommande(@RequestBody Commande commandeDetails, @PathVariable Integer id) {
    	
         Commande commande = repository.findById(id);
         commande.setUserId(commandeDetails.getUserId());
         commande.setSessionId(commandeDetails.getSessionId());
         commande.setDate(commandeDetails.getDate());
         commande.setStatus(commandeDetails.getStatus());

         Commande commandToUpdate = repository.save(commande);
         
		 return commandToUpdate;
         
    }
    
    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
	public List<Commande> findByUser(@PathVariable Integer userId) {
        List<Commande> commandes = new ArrayList<>(repository.findByUser(userId));
        if (commandes.isEmpty()){
            throw new CommandeIntrouvableException("Il n'existe aucune commande avec l'id : " + userId);
        }
        return commandes;
	}
    
    
}