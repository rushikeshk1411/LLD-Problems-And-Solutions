package com.vegayan.globallogin;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GlobalLoginApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GlobalLoginApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GlobalLoginApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<ErrorPageFilter> disableErrorPageFilter() {
		FilterRegistrationBean<ErrorPageFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new ErrorPageFilter());
		registration.setEnabled(false);
		return registration;
	}
}
