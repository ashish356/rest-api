package com.expleo.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expleo.restapi.entity.Resource;



public interface ResourceRepository extends JpaRepository<Resource, Long> {
	
	// Jpa Repository provides all methods to interact with database finalAll, find, save, update etc.

}
