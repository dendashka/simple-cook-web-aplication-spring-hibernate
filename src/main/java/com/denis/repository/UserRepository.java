package com.denis.repository;

import org.springframework.data.repository.CrudRepository;

import com.denis.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
}
