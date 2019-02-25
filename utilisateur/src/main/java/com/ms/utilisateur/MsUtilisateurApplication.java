package com.ms.utilisateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class MsUtilisateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUtilisateurApplication.class, args);
	}
	@Bean
	Sampler getSample() {
		return Sampler.ALWAYS_SAMPLE;
		
	}
}

