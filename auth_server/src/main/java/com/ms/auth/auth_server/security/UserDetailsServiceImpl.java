package com.ms.auth.auth_server.security;

import com.ms.auth.auth_server.bean.UserBean;
import com.ms.auth.auth_server.proxy.UtilisateurProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurProxy utilisateurProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserBean userAccount = utilisateurProxy.findByUsername(username);

        System.out.println("Le user est :" + userAccount.getUsername() +
                " est a un role de : " + userAccount.getRole());
        if (userAccount.getUsername().equals(username)){
            // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
            // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + userAccount.getRole());

            // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
            // And used by auth manager to verify and check user authentication.
            return new User(userAccount.getEmail(), userAccount.getPassword(), grantedAuthorities);

        }

        else
            throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
