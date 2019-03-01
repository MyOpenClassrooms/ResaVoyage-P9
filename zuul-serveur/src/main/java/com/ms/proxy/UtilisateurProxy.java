package com.ms.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.common.base.Optional;
import com.ms.model.Utilisateur;

@FeignClient(name = "microservice-utilisateur")
@RibbonClient(name = "microservice-utilisateur")
public interface UtilisateurProxy {
	@PostMapping(value = "/user/username")
    Utilisateur getUserByUsername(@RequestBody String username);

}
