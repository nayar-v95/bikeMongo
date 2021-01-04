package com.bikemongo.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.bikemongo.api.model.Bike;
import com.bikemongo.api.repositories.BikeRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/bikes")
public class BikeController {
	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping()
	public Iterable<Bike> getBikes(){
		
		return  bikeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Bike>  getBike(@PathVariable String id) {
		return bikeRepository.findById(id);
	}
	
	@GetMapping("/email/{email}")
	public  Iterable<Bike>  getbyEmail(@PathVariable String email) {
		email = email.replace("\"", "");
		List<Bike> bikes = new ArrayList<Bike>();

		Iterable<Bike> allBikes = getBikes();
		for (Bike bike : allBikes) {
			if (bike.getEmail().equals(email)) {
				bikes.add(bike);
			}
		}
		return bikes;
		
	}
	
	@ResponseBody
	@PostMapping( headers = {
	            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Bike addBike(@RequestBody Bike bike) {
		return  bikeRepository.save(bike);
			
	}
	
	@DeleteMapping("/{id}")
	public String deleteBike(@PathVariable String id) {
		bikeRepository.deleteById(id);
		return "Deleted";
	}
	@PatchMapping("/{id}")
	public String updateBike(@PathVariable String id,@RequestBody Bike bike) {
		return "failed";
		
	}
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		bikeRepository.deleteAll();
		return "Deleted All";
	}
	
	
}
