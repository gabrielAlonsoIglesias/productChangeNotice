package com.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public WebSecurityConfig() {
		super(false);
	}

	protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity) ((HttpSecurity) ((HttpSecurity) http.csrf().disable()).sessionManagement()
        																	  .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        																	  .and()).cors().and()).headers().frameOptions().disable();
	}

}
