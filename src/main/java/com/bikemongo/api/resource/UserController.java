package com.bikemongo.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikemongo.api.model.User;
import com.bikemongo.api.repositories.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/v1/users")
	public Iterable<User> getUsers(){
		return  userRepository.findAll();
	}
	@GetMapping("/api/v1/user/email/{email}")
	public User  getbyEmail(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}
	@ResponseBody
	@PostMapping(value = "/api/v1/user/register", headers = {
	            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addBike(@RequestBody User user) {
		return  userRepository.save(user);
			
	}
	@DeleteMapping("/api/v1/user/{email}")
	public String deleteBike(@PathVariable String email) {
		userRepository.deleteById(email);
		return "Deleted";
	}
	@PatchMapping("/api/v1/user/{email}")
	public String updateBike(@PathVariable String email,@RequestBody User user) {
		return "failed";
		
	}
	@DeleteMapping("/api/vq/users/deleteAll")
	public String deleteAll() {
		userRepository.deleteAll();
		return "Deleted All";
	}

	@ResponseBody
	@PostMapping("/api/v1/user/login")
	public boolean login(@RequestBody User user) {
		User fetchedUser;
		fetchedUser = getbyEmail(user.getEmail());
		System.out.println(user.toString());
		System.out.println(fetchedUser.toString());
		
		if(fetchedUser.getPassword().equals(user.getPassword()) )
			return true;
		return false;
	}
	
	
}
