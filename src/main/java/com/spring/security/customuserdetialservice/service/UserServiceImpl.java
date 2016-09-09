package com.spring.security.customuserdetialservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.customuserdetialservice.entities.Role;
import com.spring.security.customuserdetialservice.entities.User;
import com.spring.security.customuserdetialservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(userEmail);
	}

	@Override
	public ArrayList<Role> findRolesByRoleId(int role_id) {
		// TODO Auto-generated method stub
		return userRepository.findRolesByRoleId(role_id);
	}

}
