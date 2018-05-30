package com.chen.longhai.sbjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SbJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbJpaApplication.class, args);
	}
}
