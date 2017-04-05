package com.rest;

import java.util.HashSet;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemRepository;
import com.rest.velocity.Efc;
import com.rest.velocity.Item;
import com.rest.velocity.ItemInfo;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	HashSet<Efc> efcs = new HashSet<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/webapp/");
		return resolver;
	}

	@Bean
	public CommandLineRunner setup(ItemRepository itemRepository, ItemInfoRepository itemInfoRepository) {
		return (args) -> {
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

			logger.info("The sample data has been generated");
		};
	}
	
//	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	 private Connector initiateHttpConnector() {
		    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		    connector.setScheme("http");
		    connector.setPort(8080);
		    connector.setSecure(false);
		   connector.setRedirectPort(8888);
		    
		    return connector;
		  }
}
