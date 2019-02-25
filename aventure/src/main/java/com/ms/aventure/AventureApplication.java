package com.ms.aventure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AventureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AventureApplication.class, args);
	}
//Exportation des requétes vers zipkin
	@Bean
	Sampler getSample() {
		return Sampler.ALWAYS_SAMPLE;
		
	}
}
