package com.chocopay.invoice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxRepository extends JpaRepository<Tax, Long>{
	Optional<Tax> findById(long id);
	Optional<Tax> findByName(String name);
}
