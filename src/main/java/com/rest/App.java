package com.rest;

import com.rest.model.person.Person;
import com.rest.model.velocity.Efc;
import com.rest.model.velocity.Item;
import com.rest.model.velocity.ItemInfo;
import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemRepository;
import com.rest.repository.PersonRepository;
import io.hawt.config.ConfigFacade;
import io.hawt.springboot.EnableHawtio;
import io.hawt.springboot.HawtPlugin;
import io.hawt.springboot.PluginService;
import io.hawt.web.AuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
@EnableHawtio
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private HashSet<Efc> efcs = new HashSet<>();

    public static void main(String[] args) {
        System.setProperty("hawtio.authenticationEnabled", "false");
        System.setProperty(AuthenticationFilter.HAWTIO_AUTHENTICATION_ENABLED, "false");
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner setup(ItemRepository itemRepository, ItemInfoRepository itemInfoRepository, PersonRepository personRepository) {
        return (args) -> {
            efcs.add(new Efc("6", "66666"));
            efcs.add(new Efc("5", "55555"));
            efcs.add(new Efc("4", "44444"));
            efcs.add(new Efc("3", "33333"));
            efcs.add(new Efc("2", "22222"));
            efcs.add(new Efc("1", "11111"));
            itemRepository.save(new Item("1", efcs));
            itemRepository.save(new Item("2", efcs));
            itemRepository.save(new Item("62900001", efcs));

            itemInfoRepository.save(new ItemInfo("91218652", "H10 JLO GLOW SET", "pretty high", null, null, null, null,
                    null, null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2",
                    "N", "N", null, null));

            itemInfoRepository.save(new ItemInfo("111", "H10 JLO GLOW SET", "pretty high", null, null, null, null, null,
                    null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2", "N",
                    "N", null, null));

            itemInfoRepository.save(new ItemInfo("222", "H10 JLO GLOW SET", "pretty high", null, null, null, null, null,
                    null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2", "N",
                    "N", null, null));

            itemInfoRepository.save(new ItemInfo("333", "H10 JLO GLOW SET", "pretty high", null, null, null, null, null,
                    null, null, null, null, null, "N", "N", "MULTI/NONE", "20", "422", "91218649", "21", "N", "2", "N",
                    "N", null, null));

            personRepository.save(new Person(1l, "Pesho", "Peshkata"));
            personRepository.save(new Person(2l, "Gosho", "Goshkata"));
            logger.info("The sample data has been generated");
        };
    }

    /**
     * Loading an example plugin
     *
     * @return
     */
    @Bean
    public HawtPlugin samplePlugin() {
        return new HawtPlugin("sample-plugin", "/hawtio/plugins", "",
                new String[]{"sample-plugin/js/sample-plugin.js"});
    }

    /**
     * Set things up to be in offline mode
     *
     * @return
     * @throws Exception
     */
    @Bean
    public ConfigFacade configFacade() throws Exception {
        ConfigFacade config = new ConfigFacade() {
            public boolean isOffline() {
                return true;
            }
        };
        config.init();
        return config;
    }

    /**
     * Register rest endpoint to handle requests for /plugin, and return all
     * registered plugins.
     *
     * @return
     */
    @Bean
    public PluginService pluginService() {
        return new PluginService();
    }

}
