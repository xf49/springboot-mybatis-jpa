package com.xuming.springboot.userRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xuming.springboot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	User findByFirstName(String firstName);

}
