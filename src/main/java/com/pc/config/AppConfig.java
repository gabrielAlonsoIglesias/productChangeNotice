package com.pc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.pc.config.Configurer.TipoAplicacion;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.pc.*"})
public class AppConfig {

	public AppConfig() {
		super();
	}

    @Bean
  	public Configurer configurer()  {
    	 final Configurer configurer = new Configurer();
    	 configurer.setTipoAplicacion(TipoAplicacion.WEB);
    	 configurer.setHasToken(false);
    	 return configurer;
  	}

}