package com.example.rest.websevices.restfullwebservice;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfullWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfullWebServiceApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver () {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}

	
}

