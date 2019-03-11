package com.ms.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.utilisateur.model.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>  {
	
	
    int countUtilisateurByEmail(String email);
	int countUtilisateurByUsername(String username);
	Utilisateur getByUsername(String username);
	Utilisateur findByEmail(String email);

}
