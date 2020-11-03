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

import com.concess.api.entity.Vendor;
import com.concess.api.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	//Create a new vendor
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Vendor vendor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.save(vendor));
	}
	
	//Read an vendor
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<Vendor> oVendor = vendorService.findById(id);
		
		if(!oVendor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oVendor);
	}
	
	//Update an vendor
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Vendor vendorDetails, @PathVariable Long id) {
		Optional<Vendor> oVendor = vendorService.findById(id);
		
		if(!oVendor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oVendor.get().setNationalId(vendorDetails.getNationalId());
		oVendor.get().setFullName(vendorDetails.getFullName());
		oVendor.get().setConcessionary(vendorDetails.getConcessionary());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.save(oVendor.get()));
	}
		
	//Delete an vendor
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Vendor> oVendor = vendorService.findById(id);
		
		if(!oVendor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		vendorService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//Read all vendors
	@GetMapping
	public List<Vendor> readAll() {
		
		List<Vendor> vendors = StreamSupport
				.stream(vendorService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return vendors;
	}
}
