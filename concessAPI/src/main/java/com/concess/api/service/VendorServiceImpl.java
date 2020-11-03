package com.concess.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concess.api.entity.Vendor;
import com.concess.api.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Vendor> findAll() {
		return vendorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Vendor> findAll(Pageable pageable) {
		return vendorRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendor> findById(Long id) {
		return vendorRepository.findById(id);
	}

	@Override
	@Transactional
	public Vendor save(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		vendorRepository.deleteById(id);
	}
}
