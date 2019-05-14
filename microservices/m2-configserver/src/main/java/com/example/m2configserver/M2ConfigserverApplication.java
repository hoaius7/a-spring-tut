package com.example.m2configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class M2ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2ConfigserverApplication.class, args);
	}

}
