package com.example.LLD;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan
public class ParkingLotApplication {
	public static void main(String[] args) {
//		SpringApplication.run(SnakeAndLadderApplication.class, args);
	}
}
