package com.concess.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concess.api.entity.VehicleSale;
import com.concess.api.repository.VehicleSaleRepository;

@Service
public class VehicleSaleServiceImpl implements VehicleSaleService {

	@Autowired
	private VehicleSaleRepository vehicleSaleRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<VehicleSale> findAll() {
		return vehicleSaleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<VehicleSale> findAll(Pageable pageable) {
		return vehicleSaleRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<VehicleSale> findById(Long id) {
		return vehicleSaleRepository.findById(id);
	}

	@Override
	@Transactional
	public VehicleSale save(VehicleSale vehicleSale) {
		return vehicleSaleRepository.save(vehicleSale);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		vehicleSaleRepository.deleteById(id);
	}	
	
}
