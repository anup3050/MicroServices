package com.example.rest.websevices.restfullwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(path="/filtering")
	public MappingJacksonValue retriveSomeBean() {
		
		SomeBean someBean = new SomeBean("Value1","Value2","Value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping(path="/filtering-list")
	public MappingJacksonValue retriveSomeBeanList() {
		
		List someBeanList = Arrays.asList((new SomeBean("Value1","Value2","Value3")),new SomeBean("Value11","Value22","Value33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
		mapping.setFilters(filters);
		
		
		return mapping;
	}
}
