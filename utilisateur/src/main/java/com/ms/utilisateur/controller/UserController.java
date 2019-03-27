package com.ms.utilisateur.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ms.utilisateur.model.Utilisateur;
import com.ms.utilisateur.repository.UtilisateurDao;

@RestController
public class UserController {

	@Autowired
	private UtilisateurDao utilisateurDao;

	@PostMapping(value = "/utilisateur/save")
	public void add(@RequestBody Utilisateur utilisateur) {

		int nbusername = utilisateurDao.countUtilisateurByUsername(utilisateur.getUsername());
		int nbemail = utilisateurDao.countUtilisateurByEmail(utilisateur.getEmail());

		if (nbusername != 1 && nbemail != 1) {
			utilisateur.setRole("ADMIN");
			String pass = utilisateur.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(pass);
            utilisateur.setPassword(hashedPassword);
			utilisateurDao.save(utilisateur);
		}
	}

	@PostMapping(value = "/utilisateur/update")
	public void update(@RequestBody Utilisateur utilisateur) {

		if (utilisateur.getIdutilisateur() != null) {

			Optional<Utilisateur> user = utilisateurDao.findById(utilisateur.getIdutilisateur());
			if (user.isPresent()) {

				utilisateurDao.save(utilisateur);

			}

		}

	}


    @GetMapping(value = "/utilisateur/email/{email}")
    public Utilisateur findByEmail(@PathVariable String email) {
        return utilisateurDao.findByEmail(email);
    }


    @GetMapping(value = "/utilisateur/id/{id}")
	public Utilisateur findById(@PathVariable Long id) {
		return utilisateurDao.getOne(id);
	}

    @GetMapping(value = "/utilisateur/username/{username}")
    public Utilisateur findByUsername(@PathVariable String username){
        return utilisateurDao.getByUsername(username);
    }



}
