package com.chocopay.invoice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>{
	Optional<Goods> findById(long id);
	Optional<Goods> findByInvoiceId(long invoiceId);
	Optional<Goods> findByTaxId(long taxId);
}
