package com.poc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author galonsoi
 */
@ConfigurationProperties
@Configuration
@ComponentScan(basePackages = {"com.poc.*"})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {

	private static final Log LOG = LogFactory.getLog(Application.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			LOG.info("main # ENTER");

			final SpringApplication application = new SpringApplicationBuilder(Application.class).properties("spring.config.name:application")
																								 .build();
			application.run(args);

			LOG.info("main # EXIT");
		} catch (Exception e) {
			LOG.error("main # ERROR. Cause: " + e);
		}
	}

}