package com.example.rest.websevices.restfullwebservice.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {

	@Autowired
	UserDaoService userDaoService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	@GetMapping(path = "/jpa/users")
	public List<User> retriveAllUsers() {

		return userRepository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retriveUser(@PathVariable Integer id) {

		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found!");
		}
		
		Resource<User> resource = new Resource<User>(user.get());
		
		 ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
		 
		 resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {

		userRepository.deleteById(id);
		

	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity saveUser(@Valid @RequestBody User user) {
		User newUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrivePost(@PathVariable Integer id) {

		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found!");
		}
		
		//Resource<User> resource = new Resource<User>(user.get());
		
		 //ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
		 
		 //resource.add(linkTo.withRel("all-users"));
		return user.get().getPost();
	}
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity saveUserPost(@PathVariable Integer id, @RequestBody Post post) {
		
		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found!");
		}
		
		User user = optionalUser.get();
		post.setUser(user);
		Post postUser = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}


}
