package com.rest;

import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.rest.repository.ItemInfoRepository;
import com.rest.repository.ItemRepository;
import com.rest.velocity.Efc;
import com.rest.velocity.Item;
import com.rest.velocity.ItemInfo;

import io.hawt.config.ConfigFacade;
import io.hawt.springboot.EnableHawtio;
import io.hawt.springboot.HawtPlugin;
import io.hawt.springboot.PluginService;
import io.hawt.system.ConfigManager;
import io.hawt.web.AuthenticationFilter;

@SpringBootApplication
@EnableHawtio
public class Application extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private ServletContext servletContext;

	HashSet<Efc> efcs = new HashSet<>();

	public static void main(String[] args) {
		System.setProperty("hawtio.authenticationEnabled", "false");
		System.setProperty(AuthenticationFilter.HAWTIO_AUTHENTICATION_ENABLED, "false");
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	public CommandLineRunner setup(ItemRepository itemRepository, ItemInfoRepository itemInfoRepository) {
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
	// @PostConstruct
		public void init() {
			final ConfigManager configManager = new ConfigManager();
			configManager.init();
			servletContext.setAttribute("ConfigManager", configManager);
		}

		/**
		 * Loading an example plugin
		 * @return
		 */
		//@Bean
		public HawtPlugin samplePlugin() {
			return new HawtPlugin("sample-plugin", "/hawtio/plugins", "", new String[] { "sample-plugin/js/sample-plugin.js" });
		}
		
		/**
		 * Set things up to be in offline mode
		 * @return
		 * @throws Exception
		 */
		//@Bean
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
		 * Register rest endpoint to handle requests for /plugin, and return all registered plugins.
		 * @return
		 */
		//@Bean
		public PluginService pluginService(){
			return new PluginService();
		}
}
