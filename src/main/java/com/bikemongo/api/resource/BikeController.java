package com.bikemongo.api.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikemongo.api.model.Bike;
import com.bikemongo.api.repositories.BikeRepository;
import com.mongodb.BasicDBObject;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BikeController {
	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping("/api/v1/bikes")
	public Iterable<Bike> getBikes(){
		
		return  bikeRepository.findAll();
	}
	
	@GetMapping("/api/v1/bikes/{id}")
	public Optional<Bike>  getBike(@PathVariable String id) {
		return bikeRepository.findById(id);
	}
	
	@GetMapping("/api/v1/bikes/email/{email}")
	public Bike  getbyEmail(@PathVariable String email) {
		System.out.println(email);
		return bikeRepository.findByEmail(email);
		
	}
	
	@ResponseBody
	@PostMapping(value = "/api/v1/bikes", headers = {
	            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Bike addBike(@RequestBody Bike bike) {
		return  bikeRepository.save(bike);
			
	}
	
	@DeleteMapping("/api/v1/bikes/{id}")
	public String deleteBike(@PathVariable String id) {
		bikeRepository.deleteById(id);
		return "Deleted";
	}
	@PatchMapping("/api/v1/bikes/{id}")
	public String updateBike(@PathVariable String id,@RequestBody Bike bike) {
		return "failed";
		
	}
	@DeleteMapping("/api/vq/bikes/deleteAll")
	public String deleteAll() {
		bikeRepository.deleteAll();
		return "Deleted All";
	}
	
	
}
