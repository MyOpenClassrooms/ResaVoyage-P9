package com.ms.paiement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class PaiementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaiementApplication.class, args);
	}
	@Bean
	Sampler getSample() {
		return Sampler.ALWAYS_SAMPLE;
		
	}
}

