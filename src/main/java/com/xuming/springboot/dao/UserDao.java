package com.xuming.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.xuming.springboot.model.User;

@Mapper
public interface UserDao {
	
	@Select("SELECT first_name,last_name FROM user WHERE user_id = #{id}")
	User findUserById(@Param("id") int id);
	
	@Select("SELECT * FROM user WHERE first_name = #{firstName}")
	User findUserByFirstName(@Param("firstName") String firstName);
	
	@Select("SELECT * FROM user WHERE last_name = #{lastName}")
	User findUserByLastName(@Param("lastName") String lastName);
	
	@Select("SELECT * FROM user order by salary desc")
	List<User> findAllUsers();
	
	@Select("SELECT * FROM user WHERE first_name=#{firstName} AND last_name=#{lastName} AND department=#{department} AND age=#{age} AND salary=#{salary}")
	User findUserSpecifically(@Param("firstName") String firstName,@Param("lastName") String lastName,
	        @Param("department") String department,@Param("age") int age,@Param("salary") double salary);
	
	@Insert("INSERT INTO user(first_name,last_name,department,age,salary) VALUES(#{firstName},#{lastName},#{department},#{age},#{salary})")
	void insertUser(@Param("firstName") String firstName,@Param("lastName") String lastName,
			        @Param("department") String department,@Param("age") int age,@Param("salary") double salary);

	@Update("UPDATE user SET first_name=#{firstName},last_name=#{lastName},department=#{department},age=#{age},salary=#{salary} WHERE user_id =#{id}")
	User updateUserById(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("department") String department,
			            @Param("age") int age,@Param("salary") double salary,@Param("id") int id);
	
	@Delete("DELETE FROM user WHERE user_id = #{id}")
	void deleteUserById(@Param("id") int id);
	
	@Delete("DELETE FROM user")
	void deleteAllUsers();
	
	
	User getUserByFirstName(String firstName);
}
