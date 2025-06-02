package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface IUserRepo extends JpaRepository<Users, String> {

	Users findByUsername(String userName);
}
