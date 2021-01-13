package com.poc.config;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

/**
 * @author galonsoi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private static final String WEB_ROOT = "/web/*";

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	@Bean
	public ServletRegistrationBean<?> dispatcherServletRegistration() {
		ServletRegistrationBean<?> registration = new ServletRegistrationBean<>(dispatcherServlet(), WEB_ROOT);
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
		return registration;
	}

	@Bean
	public FilterRegistrationBean<Filter> filterRegistrationBean() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setForceEncoding(true);
	    characterEncodingFilter.setEncoding("UTF-8");
	    registrationBean.setFilter(characterEncodingFilter);
	    return registrationBean;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public XmlViewResolver xmlViewResolver() {
		return new XmlViewResolver();
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

}