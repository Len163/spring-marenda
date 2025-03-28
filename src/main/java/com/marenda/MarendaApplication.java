package com.marenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MarendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarendaApplication.class, args);
	}

}
