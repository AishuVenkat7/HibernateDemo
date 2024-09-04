package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.banking.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
		void deleteByEmail(String email);

}
