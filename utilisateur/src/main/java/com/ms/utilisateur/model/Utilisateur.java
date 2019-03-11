package com.ms.utilisateur.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idutilisateur;
	private String username;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String postcode;
	private String phonenumber;
	private String role;


    public Utilisateur(String username, String email, String password, String firstname, String lastname, String address, String postcode, String phonenumber, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.postcode = postcode;
        this.phonenumber = phonenumber;
        this.role = role;
    }

    public Utilisateur() {
    }

    public Long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "idutilisateur=" + idutilisateur +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
