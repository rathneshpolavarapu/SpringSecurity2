package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.userservice;

@RestController
public class UserController {
	
	@Autowired
	private userservice service;
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(12);
	
	@PostMapping("/add-newuser")
	public Users registerNewUser(@RequestBody Users user) {
		
		String Password=user.getPassword();
		String encodedPassword=bcrypt.encode(Password);
		user.setPassword(encodedPassword);
		return service.registersUser(user);
	}

}
