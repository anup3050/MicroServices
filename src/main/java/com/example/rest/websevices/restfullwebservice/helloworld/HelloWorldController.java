package com.example.rest.websevices.restfullwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
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
}
