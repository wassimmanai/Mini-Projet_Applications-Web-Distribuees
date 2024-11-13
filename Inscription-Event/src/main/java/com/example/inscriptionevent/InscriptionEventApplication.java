package com.example.inscriptionevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class InscriptionEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscriptionEventApplication.class, args);
	}

}
