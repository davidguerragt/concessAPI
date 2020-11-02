package com.concess.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concess.api.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
