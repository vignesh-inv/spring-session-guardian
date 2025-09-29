package com.example.Securitylearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Securitylearn.model.Users;

@Repository
public interface SpringRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
}
