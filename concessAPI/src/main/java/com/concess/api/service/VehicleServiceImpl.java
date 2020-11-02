package com.concess.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concess.api.entity.Vehicle;
import com.concess.api.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Vehicle> findAll(Pageable pageable) {
		return vehicleRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> findById(Long id) {
		return vehicleRepository.findById(id);
	}

	@Override
	@Transactional
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		vehicleRepository.deleteById(id);
	}	
	
}
