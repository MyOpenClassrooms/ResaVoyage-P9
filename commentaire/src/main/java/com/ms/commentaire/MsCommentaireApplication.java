package com.ms.commentaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class MsCommentaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCommentaireApplication.class, args);
	}
	@Bean
	Sampler getSample() {
		return Sampler.ALWAYS_SAMPLE;
		
	}
}

