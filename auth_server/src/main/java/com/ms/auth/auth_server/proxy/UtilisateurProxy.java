package com.ms.auth.auth_server.proxy;

import com.ms.auth.auth_server.bean.UserBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservice-utilisateur")
@RibbonClient(name = "microservice-utilisateur")
public interface UtilisateurProxy {

    @GetMapping(value = "/utilisateur/username/{username}")
    UserBean findByUsername(@PathVariable(name = "username") String username);
}
