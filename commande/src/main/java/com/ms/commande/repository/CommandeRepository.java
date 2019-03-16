package com.ms.commande.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.commande.model.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Long>{
	  List<Commande> findByDate(Date date);
	
	  Commande findById(Integer id);
	  @Query("SELECT c FROM Commande c WHERE c.userId =:userId")
	  List<Commande> findByUser(@Param("userId")Integer  userId);
}
