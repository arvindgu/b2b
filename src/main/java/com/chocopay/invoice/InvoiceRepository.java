package com.chocopay.invoice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	Optional<Invoice> findByInvoiceId(long invoiceId);
	Optional<Invoice> findBySupplierBusinessId(long supplierBusinessId);
	Optional<Invoice> findByRetailerBusinessId(long retailerBusinessId);
}
