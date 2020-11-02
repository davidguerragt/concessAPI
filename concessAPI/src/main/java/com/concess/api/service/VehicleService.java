package com.concess.api.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.concess.api.entity.Vehicle;

public interface VehicleService {
	public Iterable<Vehicle> findAll();
	public Page<Vehicle> findAll(Pageable pageable);
	public Optional<Vehicle> findById(Long id);
	public Vehicle save(Vehicle vehicle);
	public void deleteById(Long id);
}
