package com.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.poc.util.Utils;

/**
 * @author galonsoi
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.poc.repository"})
@ComponentScan(basePackages = {"com.poc.*"})
public class MongoDBConfig extends AbstractMongoConfiguration {

	private static final String ENTITIES_PCK_NAME = "com.poc.entity";

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.port}")
	private String port;

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.username}")
	private String username;

	@Value("${spring.data.mongodb.password}")
	private String password;
	
	@Autowired
	private Utils utils;

	@Override
	protected String getDatabaseName() {
		return this.database;
	}

	@Override
	protected String getMappingBasePackage() {
		return ENTITIES_PCK_NAME;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClient(), getDatabaseName());
	}

	@Override
	@Bean
	public MongoClient mongoClient() {
		String uri = this.utils.concat("mongodb+srv://", this.username, ":", this.password, "@", this.host, "/", this.database, "?retryWrites=true&w=majority");
		return new MongoClient(new MongoClientURI(uri));
	}

} 