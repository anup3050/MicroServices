package com.example.rest.websevices.restfullwebservice.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {

		return userDaoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retriveUser(@PathVariable Integer id) {

		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("User Not Found!");
		}
		
		Resource<User> resource = new Resource<User>(user);
		
		 ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
		 
		 resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {

		User user = userDaoService.deleteUserById(id);
		if (user == null) {
			throw new UserNotFoundException("User Not Found!");
		}

	}

	@PostMapping(path = "/users")
	public ResponseEntity saveUser(@Valid @RequestBody User user) {
		User newUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
