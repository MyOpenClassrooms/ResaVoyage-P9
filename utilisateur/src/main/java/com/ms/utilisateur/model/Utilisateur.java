package com.ms.utilisateur.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	
	public Long getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idutilisateur;
	private String pseudo;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String postcode;
	
	private String phonenumber;
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Utilisateur(String pseudo, String email, String password, String firstname, String lastname, String address,
			String postcode, String phonenumber) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.postcode = postcode;
		
		this.phonenumber = phonenumber;
	}
	public Utilisateur() {
		super();
	}
	
	

}
