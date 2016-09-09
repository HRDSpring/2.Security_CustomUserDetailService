package com.spring.security.customuserdetialservice.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.spring.security.customuserdetialservice.entities.Role;
import com.spring.security.customuserdetialservice.entities.User;

@Repository
public interface UserRepository {

	@Select("SELECT id, username, password, email, role_id FROM users WHERE email=#{userEmail}")
	@Results(value = {
			@Result(property = "roles", column = "role_id",
				many = @Many(select = "findRolesByRoleId")
			)
	})
	public User findUserByEmail(@Param("userEmail") String userEmail);

	@Select("SELECT id, role_name FROM roles WHERE id=#{role_id}")
	@Results(value = {
		@Result(property="id" , column="id"),
		@Result(property="role_name" , column="role_name")
	})
	public ArrayList<Role> findRolesByRoleId( int role_id);
	
	
}
