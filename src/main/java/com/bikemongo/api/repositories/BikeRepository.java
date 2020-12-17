package com.bikemongo.api.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bikemongo.api.model.Bike;

public interface BikeRepository extends ReactiveMongoRepository<Bike, String> {

}
