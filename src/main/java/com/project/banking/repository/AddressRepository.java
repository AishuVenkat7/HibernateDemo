package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.banking.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
}