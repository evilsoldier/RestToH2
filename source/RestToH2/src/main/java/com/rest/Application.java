package com.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rest.repository.ItemRepository;
import com.rest.velocity.Efc;
import com.rest.velocity.Item;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner setup(ItemRepository itemRepository) {
		return (args) -> {
			itemRepository.save(new Item("1", new Efc("EFC5", "1111111")));
			itemRepository.save(new Item("2", new Efc("EFC5", "2222222")));
			itemRepository.save(new Item("62900001", new Efc("EFC5", "2222222")));
			
			logger.info("The sample data has been generated");

		};
	}
}
