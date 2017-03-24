package com.rest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemRepository;
import com.rest.velocity.Efc;
import com.rest.velocity.Item;
import com.rest.velocity.ItemInfo;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	ArrayList<Efc> efcs = new ArrayList<>();
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner setup(ItemRepository itemRepository, ItemInfoRepository itemInfoRepository) {
		return (args) -> {
			efcs.add(new Efc("5", "55555"));
			efcs.add(new Efc("4", "44444"));
			efcs.add(new Efc("3", "33333"));
			efcs.add(new Efc("2", "22222"));
			efcs.add(new Efc("1", "11111"));
			itemRepository.save(new Item("1", efcs) );
			itemRepository.save(new Item("2", efcs));
			itemRepository.save(new Item("62900001", efcs));
			
			itemInfoRepository.save(new ItemInfo("111", "Y", "Y", "Y"));
			itemInfoRepository.save(new ItemInfo("222", "N", "N", "N"));
			itemInfoRepository.save(new ItemInfo("333", "N", "N", "Y"));
			itemInfoRepository.save(new ItemInfo("444", "N", "N", "Y"));
			itemInfoRepository.save(new ItemInfo("555", "N", "Y", "Y"));
			itemInfoRepository.save(new ItemInfo("666", "Y", "N", "N"));
			
			logger.info("The sample data has been generated");
		};
	}
}
