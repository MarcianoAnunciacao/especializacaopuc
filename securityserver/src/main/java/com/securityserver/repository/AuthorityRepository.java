package com.securityserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityserver.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}