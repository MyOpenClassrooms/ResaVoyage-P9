package com.ms.commentaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.commentaire.model.Commentaire;

@Repository
public interface CommentaireDao  extends JpaRepository<Commentaire, Long> {
	
	Commentaire findByIdaventure(Long idaventure);

}
