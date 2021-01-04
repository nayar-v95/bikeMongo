package com.bikemongo.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikemongo.api.model.User;
import com.bikemongo.api.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public Iterable<User> getUsers(){
		return  userRepository.findAll();
	}
	@GetMapping("/user/email/{email}")
	public User  getbyEmail(@PathVariable String email) {
		return userRepository.findAllByEmail(email);
	}
	@ResponseBody
	@PostMapping(value = "/user/register", headers = {
	            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean addUser(@RequestBody User user) {
			User  userByEmail = getbyEmail(user.getEmail());
		if(userByEmail != null) {
			System.out.println("email already in use");
			return false;
		}
		userRepository.save(user);
		return true ;
			
	}
	@DeleteMapping("/user/{email}")
	public String deleteUser(@PathVariable String email) {
		userRepository.deleteById(email);
		return "Deleted";
	}
	@PatchMapping("/user/{email}")
	public String updateUser(@PathVariable String email,@RequestBody User user) {
		return "failed";
		
	}
	@DeleteMapping("/users/deleteAll")
	public String deleteAll() {
		userRepository.deleteAll();
		return "Deleted All";
	}

	@ResponseBody
	@PostMapping("/user/login")
	public boolean login(@RequestBody User user) {
		User fetchedUser;
		boolean success = false;
		fetchedUser = getbyEmail(user.getEmail());
		System.out.println(user.toString());
		System.out.println(fetchedUser.toString());
		
		if(fetchedUser.getPassword().equals(user.getPassword()) )
			success = true;
		System.out.println(success);
		return success;
	}
	
	
}
