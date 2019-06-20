package com.xuming.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuming.springboot.dao.UserDao;
import com.xuming.springboot.model.User;
import com.xuming.springboot.userRepository.UserRepository;
//import com.xuming.springboot.userRepository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
    UserRepository userRepository;
	
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
		List<User> list = new ArrayList<User>();
		
		 userDao.findAllUsers().forEach(e->list.add(e));
		 
		 System.out.println(list);
		 
		 return list;
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
	public User addNewUser(User user) {
		List<User> users = (List<User>) userDao.findUserSpecifically(user.getFirstName(), user.getLastName(), user.getDepartment(), user.getAge(), user.getSalary());
		
		if(users.size()>0) {
			System.out.print("user already exists");
		}else {
			userDao.insertUser(user.getFirstName(), user.getLastName(), user.getDepartment(), user.getAge(), user.getSalary());
			
		}
		return user;
		
	}
	
	public User updateUserById(int id,String firstName,String lastName,String department,int age,double salary) {
		
		User user =  userDao.findUserById(id);
		
		if(user==null) {
			System.out.print(" user does not exist ");
		}else {
			user=userDao.updateUserById(firstName, lastName, department, age, salary, id);
		}
		
		return user;
		
	}
	
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
	
	public void deleteAllUsers() {
		userDao.deleteAllUsers();
	}
	
	public User getUserByFirstName(String firstName) {
		return userDao.getUserByFirstName(firstName);
	}
	
}
