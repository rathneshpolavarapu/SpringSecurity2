package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repo.IUserRepo;

@Service
public class userservice {
	
	@Autowired
	private IUserRepo repo;
	
	public Users registersUser(Users user) {
		
		return repo.save(user);
	}

}
