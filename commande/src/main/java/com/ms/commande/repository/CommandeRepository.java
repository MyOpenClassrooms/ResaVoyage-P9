package com.ms.commande.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ms.commande.model.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Long>{
	List<Commande> findByDate(Date date);
	
	  Commande findById(Integer id);
}
