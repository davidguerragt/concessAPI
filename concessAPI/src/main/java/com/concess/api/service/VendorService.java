package com.concess.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concess.api.entity.Vendor;

public interface VendorService {
	public Iterable<Vendor> findAll();
	public Page<Vendor> findAll(Pageable pageable);
	public Optional<Vendor> findById(Long id);
	public Vendor save(Vendor vendor);
	public void deleteById(Long id);
}
