package com.concess.api.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.concess.api.entity.Concessionary;

public interface ConcessionaryService {
	public Iterable<Concessionary> findAll();
	public Page<Concessionary> findAll(Pageable pageable);
	public Optional<Concessionary> findById(Long id);
	public Concessionary save(Concessionary concessionary);
	public void deleteById(Long id);
}
