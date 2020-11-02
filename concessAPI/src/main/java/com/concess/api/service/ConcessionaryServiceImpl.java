package com.concess.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concess.api.entity.Concessionary;
import com.concess.api.repository.ConcessionaryRepository;

@Service
public class ConcessionaryServiceImpl implements ConcessionaryService {

	@Autowired
	private ConcessionaryRepository concessionaryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Concessionary> findAll() {
		return concessionaryRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Concessionary> findAll(Pageable pageable) {
		return concessionaryRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Concessionary> findById(Long id) {
		return concessionaryRepository.findById(id);
	}

	@Override
	@Transactional
	public Concessionary save(Concessionary concessionary) {
		return concessionaryRepository.save(concessionary);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		concessionaryRepository.deleteById(id);
	}	
	
}
