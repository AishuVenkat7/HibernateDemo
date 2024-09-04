package com.project.banking.service.Impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.banking.entity.Address;
import com.project.banking.entity.Customer;
import com.project.banking.repository.AddressRepository;
import com.project.banking.repository.CustomerRepository;
import com.project.banking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// Check if the address already exists
		Address existingAddress = addressRepository.findById(customer.getAddress().getId()).orElse(null);

		if (existingAddress != null) {
			customer.setAddress(existingAddress);
		} else {
			// Save the new address and associate it with the customer
			addressRepository.save(customer.getAddress());
			customer.setAddress(customer.getAddress());
		}

		// Save the customer
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomer) {
		Customer existingCustomer = customerRepository.findById(updatedCustomer.getId())
				.orElseThrow(() -> new RuntimeException("customer does not exist"));

		// update name
		if (!existingCustomer.getName().equals(updatedCustomer.getName())) {
			existingCustomer.setName(updatedCustomer.getName());
		}

		// update email
		if (!existingCustomer.getEmail().equals(updatedCustomer.getEmail())) {
			existingCustomer.setEmail(updatedCustomer.getEmail());
		}

		// update address
		if (!existingCustomer.getAddress().equals(updatedCustomer.getAddress())) {
			existingCustomer.setAddress(updatedCustomer.getAddress());
		}

		// update contact
		if (!existingCustomer.getContact().equals(updatedCustomer.getContact())) {
			existingCustomer.setContact(updatedCustomer.getContact());
		}

		// update account
		if (!existingCustomer.getAccounts().equals(updatedCustomer.getAccounts())) {
			existingCustomer.setAccounts(updatedCustomer.getAccounts());
		}

		return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomer(String email) {
		customerRepository.deleteByEmail(email);
	}

}
