package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class M5ZipkinserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(M5ZipkinserverApplication.class, args);
	}

}
