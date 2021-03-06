package com.example.rest.websevices.restfullwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource; 
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		
		return "Hello World!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWordBean helloWorldBean() {
		
		return new HelloWordBean("Hello World!");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWordBean helloWorldBeanPathVariable(@PathVariable String name) {
		
		return new HelloWordBean(String.format("Hello World, %s", name));
	}
	 
	@GetMapping(path = "/hello-world-internationized")
	public String helloWorldInternationized() {
		
		return messageSource.getMessage("good.morning.message", null, 
				LocaleContextHolder.getLocale());
	}
}
