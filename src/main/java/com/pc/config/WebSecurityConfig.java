package com.pc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Configurer configurer;
  
	public WebSecurityConfig() {
		super(false);
	}

	protected void configure(HttpSecurity http) throws Exception {
		SessionCreationPolicy sessionCreationPolicy = getSessionCreationPolicy();
        ((HttpSecurity) ((HttpSecurity)((HttpSecurity)http.csrf().disable()).sessionManagement().sessionCreationPolicy(sessionCreationPolicy).and()).cors().and()).headers().frameOptions().disable();
	}

	private SessionCreationPolicy getSessionCreationPolicy() {
		SessionCreationPolicy sessionCreationPolicy = SessionCreationPolicy.IF_REQUIRED;
		if (Configurer.TipoAplicacion.WS_REST.equals(this.configurer.getTipoAplicacion())) {
			sessionCreationPolicy = SessionCreationPolicy.STATELESS;
		}
		return sessionCreationPolicy;
	}

}
