package com.bikemongo.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bikemongo.api.model.User;

public interface UserRepository extends CrudRepository<User, String> {
	User findByEmail(String email);
	User findAllByEmail(String email);
}
