package com.rest;

import com.rest.model.person.Person;
import com.rest.model.velocity.Efc;
import com.rest.model.velocity.Item;
import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemRepository;
import com.rest.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class JpaAppWritter implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private final ItemRepository itemRepository;

    private final ItemInfoRepository itemInfoRepository;

    private final PersonRepository personRepository;

    private HashSet<Efc> efcs = new HashSet<>();

    @Autowired
    public JpaAppWritter(ItemRepository itemRepository, ItemInfoRepository itemInfoRepository, PersonRepository personRepository) {
        this.itemRepository = itemRepository;
        this.itemInfoRepository = itemInfoRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Start inserting data into database...");

        efcs.add(new Efc("6", "66666"));
        efcs.add(new Efc("5", "55555"));
        efcs.add(new Efc("4", "44444"));
        efcs.add(new Efc("3", "33333"));
        efcs.add(new Efc("2", "22222"));
        efcs.add(new Efc("1", "11111"));
        itemRepository.save(new Item("1", efcs));
        itemRepository.save(new Item("2", efcs));
        itemRepository.save(new Item("62900001", efcs));

        itemInfoRepository.save(new ItemInfo(91218652L, "H10 JLO GLOW SET", "pretty high", null, null, null, null,
                null, null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2",
                "N", "N", null, null));

        itemInfoRepository.save(new ItemInfo(111L, "H10 JLO GLOW SET", "pretty high", null, null, null, null, null,
                null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2", "N",
                "N", null, null));

        itemInfoRepository.save(new ItemInfo(222L, "H10 JLO GLOW SET", "pretty high", null, null, null, null, null,
                null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2", "N",
                "N", null, null));

        itemInfoRepository.save(new ItemInfo(333L, "H10 JLO GLOW SET", "pretty high", null, null, null, null, null,
                null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2", "N",
                "N", null, null));

        personRepository.save(new Person(1L, "Pesho", "Peshkata"));
        personRepository.save(new Person(2L, "Gosho", "Goshkata"));
        logger.info("The sample data has been generated");
    }
}
