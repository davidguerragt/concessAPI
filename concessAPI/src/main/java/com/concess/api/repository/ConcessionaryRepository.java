package com.concess.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.concess.api.entity.Concessionary;

@Repository
public interface ConcessionaryRepository extends JpaRepository<Concessionary, Long>{

}
