package com.example.tape.PracticeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PracticeDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticeDemoApplication.class, args);
	}
}
