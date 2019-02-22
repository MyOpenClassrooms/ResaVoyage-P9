package com.ms.utilisateur.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.utilisateur.model.Utilisateur;
import com.ms.utilisateur.repository.UtilisateurDao;

@RestController
public class UserController {

	@Autowired
	private UtilisateurDao utilisateurDao;

	@PostMapping(value = "/utilisateur/save")
	public void add(@RequestBody Utilisateur utilisateur) {

		int nbpseudo = utilisateurDao.countUtilisateurByPseudo(utilisateur.getPseudo());
		int nbemail = utilisateurDao.countUtilisateurByEmail(utilisateur.getEmail());

		if (nbpseudo != 1 && nbemail != 1) {
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

}
