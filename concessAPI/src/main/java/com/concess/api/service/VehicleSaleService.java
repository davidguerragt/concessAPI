package com.concess.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concess.api.entity.VehicleSale;

public interface VehicleSaleService {
	public Iterable<VehicleSale> findAll();
	public Page<VehicleSale> findAll(Pageable pageable);
	public Optional<VehicleSale> findById(Long id);
	public VehicleSale save(VehicleSale vehicleSale);
	public void deleteById(Long id);
}
