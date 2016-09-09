package com.spring.security.customuserdetialservice.service;

import java.util.ArrayList;

import com.spring.security.customuserdetialservice.entities.Role;
import com.spring.security.customuserdetialservice.entities.User;

public interface UserService {
	
	public User findUserByEmail(String userEmail);
	public ArrayList<Role> findRolesByRoleId(int role_id);

}
