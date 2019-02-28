package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.ms.model.Utilisateur;
import com.ms.proxy.UtilisateurProxy;

@Service

public class UserService implements UserDetailsService {

	 @Autowired
	    private UtilisateurProxy utilisateurProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	Utilisateur utilisateur = utilisateurProxy.getUserByUsername(username);
           
            return utilisateur;
    }

}
