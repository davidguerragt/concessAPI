package com.concess.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concess.api.entity.Customer;
import com.concess.api.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//Create a new customer
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
	}
	
	//Read an customer
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<Customer> oCustomer = customerService.findById(id);
		
		if(!oCustomer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oCustomer);
	}
	
	//Update an customer
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Customer customerDetails, @PathVariable Long id) {
		Optional<Customer> oCustomer = customerService.findById(id);
		
		if(!oCustomer.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		
		oCustomer.get().setName(customerDetails.getName());
		oCustomer.get().setLastName(customerDetails.getLastName());
		oCustomer.get().setEmail(customerDetails.getEmail());
		oCustomer.get().setGender(customerDetails.getGender());
		oCustomer.get().setDateOfBirth(customerDetails.getDateOfBirth());
		oCustomer.get().setMaritalStatus(customerDetails.getMaritalStatus());
		oCustomer.get().setPersonalAddress(customerDetails.getPersonalAddress());
		oCustomer.get().setCountryId(customerDetails.getCountryId());
		oCustomer.get().setStateId(customerDetails.getStateId());
		oCustomer.get().setCityId(customerDetails.getCityId());
		oCustomer.get().setDistrictId(customerDetails.getDistrictId());
		oCustomer.get().setStatus(customerDetails.getStatus());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(oCustomer.get()));
	}
	
	
	//Delete an customer
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Customer> oCustomer = customerService.findById(id);
		
		if(!oCustomer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		customerService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//Read all customers
	@GetMapping
	public List<Customer> readAll() {
		
		List<Customer> customers = StreamSupport
				.stream(customerService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return customers;
	}
}
