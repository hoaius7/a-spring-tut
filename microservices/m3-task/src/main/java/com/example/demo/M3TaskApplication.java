package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class M3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(M3TaskApplication.class, args);
	}

	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			if (args != null) {
				System.out.println("parameter length: " + args.length);
				
				String stationId = args[1];
				String licensePlate = args[2];
				String timestamp = args[3];
				
				System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
			}
		}

	}
}
