package com.ms.commentaire.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idcommentaire;
	private Long idutilisateur;
	private Date date;
	private Long idaventure;
	private String content;




	public Long getIdcommentaire() {
		return idcommentaire;
	}
	public void setIdcommentaire(Long idcommentaire) {
		this.idcommentaire = idcommentaire;
	}
	public Long getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getIdaventure() {
		return idaventure;
	}
	public void setIdaventure(Long idaventure) {
		this.idaventure = idaventure;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Commentaire(Long idcommentaire, Long idutilisateur, Date date, Long idaventure, String content) {
		super();
		this.idcommentaire = idcommentaire;
		this.idutilisateur = idutilisateur;
		this.date = date;
		this.idaventure = idaventure;
		this.content = content;
	}
	public Commentaire() {
		super();
	}
	
	

}
