package com.xuming.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuming.springboot.dao.UserDao;
import com.xuming.springboot.model.User;
//import com.xuming.springboot.userRepository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
//	@Autowired
//	UserRepository userRepository;
	
	
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	
	public User findUserByFirstName(String firstName) {
		return userDao.findUserByFirstName(firstName);
	}
	
	
	public User findUserByLastName(String lastName) {
		return userDao.findUserByLastName(lastName);
	}
	
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}
	
	public User addUser(User user) {
		List<User> users = (List<User>) userDao.findUserSpecifically(user.getFirstName(), user.getLastName(), 
				                        user.getDepartment(), user.getAge(), user.getSalary());
		
		if(users.size()>0) {
			System.out.print("user already exists");
		}else {
			userRepository.save(user);
			
		}
		return user;
		
	}
//	public User addUser(User user) {
//		List<User> users = (List<User>) userDao.findUserSpecifically(user.getFirstName(), user.getLastName(), user.getDepartment(), user.getAge(), user.getSalary());
//		
//		if(users.size()>0) {
//			System.out.print("user already exists");
//		}else {
//			userRepository.save(user);
//			
//		}
//		return user;
//		
//	}
	
	public void updateUserById(int id,String firstName,String lastName,String department,int age,double salary) {
		
		List<User> users = (List<User>) userDao.findUserById(id);
		
		if(users.size()<=0) {
			System.out.print(" user does not exist ");
		}else {
			userDao.updateUserById(firstName, lastName, department, age, salary, id);
		}
		
	}
	
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
	
	public void deleteAllUsers() {
		userDao.deleteAllUsers();
	}
	
}
