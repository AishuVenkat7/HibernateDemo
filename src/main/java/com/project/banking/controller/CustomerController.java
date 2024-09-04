package com.project.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.entity.Customer;
import com.project.banking.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/all")
	List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/id/{id}")
	Customer getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/add")
	Customer addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/update")
	Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/delete/{email}")
	String deleteCustomer(@PathVariable String email) {
		 customerService.deleteCustomer(email);
		 return "Deleted Successfully";
	}


}
