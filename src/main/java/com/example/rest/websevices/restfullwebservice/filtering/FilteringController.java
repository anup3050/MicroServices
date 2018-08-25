package com.example.rest.websevices.restfullwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping(path="/filtering")
	public SomeBean retriveSomeBean() {
		
		return new SomeBean("Value1","Value2","Value3");
	}
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> retriveSomeBeanList() {
		
		return Arrays.asList((new SomeBean("Value1","Value2","Value3")),new SomeBean("Value11","Value22","Value33"));
	}
}
