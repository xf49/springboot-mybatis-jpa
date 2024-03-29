package com.xuming.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuming.springboot.model.User;
import com.xuming.springboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		
		User user = userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("user/{firstName}")
	public ResponseEntity<User> getUserByFirstName(@PathVariable("firstName") String firstName){
		
		User user = userService.findUserByFirstName(firstName);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	@GetMapping("user/{lastName}")
	public ResponseEntity<User> getUserByLastName(@PathVariable("lastName") String lastName){
		
		User user = userService.findUserByLastName(lastName);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public @ResponseBody Iterable<User> getAllUsers(){
		
		return userService.findAllUsers();
	}
	
	@PostMapping("user")
	public ResponseEntity<User> addUsers(@RequestBody User user){
		
		
		User newuser = userService.addUser(user);
		return new ResponseEntity<User>(newuser,HttpStatus.OK);
	}
	
	@PutMapping("user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		
		userService.updateUserById(id, user.getFirstName(), user.getLastName(), 
				user.getDepartment(), user.getAge(), user.getSalary());
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("user/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") int id){
		userService.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("user")
	public ResponseEntity<Void> deleteAllUsers(){
		userService.deleteAllUsers();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
