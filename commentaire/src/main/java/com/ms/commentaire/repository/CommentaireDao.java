package com.ms.mscommentaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.mscommentaire.model.Commentaire;

@Repository
public interface CommentaireDao  extends JpaRepository<Commentaire, Long> {
	
	Commentaire findByIdaventure(Long idaventure);

}
