package com.project.banking.service;

import java.util.List;

import com.project.banking.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomer();
	
	Customer getCustomerById(Long id);
	
	Customer saveCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(String email);

}
