package com.bikemongo.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bikemongo.api.model.Bike;
@Repository
public interface BikeRepository extends CrudRepository <Bike, String> {
	  Bike findByEmail(String email);

}
