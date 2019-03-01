package com.ms.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.utilisateur.model.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>  {
	
	
    int countUtilisateurByEmail(String email);
	Utilisateur findUtilisateurByEmail(String email);
	int countUtilisateurByPseudo(String pseudo);
	Utilisateur getByPseudo(String pseudo);

}
