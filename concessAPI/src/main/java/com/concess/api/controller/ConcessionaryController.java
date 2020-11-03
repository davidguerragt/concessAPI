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

import com.concess.api.entity.Concessionary;
import com.concess.api.service.ConcessionaryService;

@RestController
@RequestMapping("/api/concessionaries")
public class ConcessionaryController {
	
	@Autowired
	private ConcessionaryService concessionaryService;
	
	//Create a new concessionaire
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Concessionary concessionary) {
		return ResponseEntity.status(HttpStatus.CREATED).body(concessionaryService.save(concessionary));
	}
	
	//Read an concessionaire
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<Concessionary> oConcessionary = concessionaryService.findById(id);
		
		if(!oConcessionary.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oConcessionary);
	}
	
	//Update an concessionaire
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Concessionary concessionaryDetails, @PathVariable Long id) {
		Optional<Concessionary> oConcessionary = concessionaryService.findById(id);
		
		if(!oConcessionary.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		oConcessionary.get().setShortName(concessionaryDetails.getShortName());
		oConcessionary.get().setFullName(concessionaryDetails.getFullName());
		oConcessionary.get().setStatus(concessionaryDetails.getStatus());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(concessionaryService.save(oConcessionary.get()));
	}
	
	
	//Delete an concessionaire
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Concessionary> oConcessionary = concessionaryService.findById(id);
		
		if(!oConcessionary.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		concessionaryService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//Read all concessionaries
	@GetMapping
	public List<Concessionary> readAll() {
		
		List<Concessionary> concessionaries = StreamSupport
				.stream(concessionaryService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return concessionaries;
	}
}
