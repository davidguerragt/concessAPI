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

import com.concess.api.entity.VehicleSale;
import com.concess.api.service.VehicleSaleService;

@RestController
@RequestMapping("/api/vehiclesales")
public class VehicleSaleController {
	
	@Autowired
	private VehicleSaleService vehicleSaleService;
	
	//Create a new vehicleSale
	@PostMapping
	public ResponseEntity<?> create (@RequestBody VehicleSale vehicleSale) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleSaleService.save(vehicleSale));
	}
	
	//Read an vehicleSale
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<VehicleSale> oVehicleSale = vehicleSaleService.findById(id);
		
		if(!oVehicleSale.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oVehicleSale);
	}
	
	//Update an vehicleSale
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody VehicleSale vehicleSaleDetails, @PathVariable Long id) {
		Optional<VehicleSale> oVehicleSale = vehicleSaleService.findById(id);
		
		if(!oVehicleSale.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oVehicleSale.get().setCustomerNationalId(vehicleSaleDetails.getCustomerNationalId());
		oVehicleSale.get().setConcessionaryShortName(vehicleSaleDetails.getConcessionaryShortName());
		oVehicleSale.get().setVehiclePlateNumber(vehicleSaleDetails.getVehiclePlateNumber());
		oVehicleSale.get().setVendorNationalId(vehicleSaleDetails.getVendorNationalId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleSaleService.save(oVehicleSale.get()));
	}
	
	
	//Delete an vehicleSale
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<VehicleSale> oVehicleSale = vehicleSaleService.findById(id);
		
		if(!oVehicleSale.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		vehicleSaleService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//Read all vehicleSales
	@GetMapping
	public List<VehicleSale> readAll() {
		
		List<VehicleSale> vehicleSales = StreamSupport
				.stream(vehicleSaleService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return vehicleSales;
	}
}
