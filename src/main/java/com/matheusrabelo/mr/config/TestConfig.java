package com.matheusrabelo.mr.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusrabelo.mr.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
// todos os bin só será ativado quando os profiles forem criado

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		dbService.instantiateTestDatabase();
		return true;

	}

}
