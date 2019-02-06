package com.ms.commande.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.commande.model.Commande;
import com.ms.commande.repository.CommandeRepository;
 
@RestController
public class CommandeController {
	@Autowired
	CommandeRepository repository;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Commande> findAll(){
		 return repository.findAll();
	}
    
    @GetMapping(value = "/findById/{id}")
    public Commande findById(@PathVariable Integer id) {
        return repository.findById(id);
    }
	
    @PostMapping (value = "/save")
    public void saveCommande(@RequestBody Commande commande) {
    	repository.save(commande);
    }
    
    @PutMapping (value = "/update/{id}")
    public void updateCommande(@RequestBody Commande commance, @PathVariable Integer id) {
    	
    	Commande commandToUpdate = repository.findById(id);
    	 if(commandToUpdate != null){
    		 repository.save(commance);
    		  }	
    }
    
    
    
}