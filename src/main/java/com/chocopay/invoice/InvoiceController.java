package com.chocopay.invoice;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/chocopay/api")
public class InvoiceController {
    
	 @Autowired
	 InvoiceRepository invoiceRepository;	 
	 
	 @GetMapping("/invoice")
	 public Collection<Invoice> getAllInvoice() {
	     return invoiceRepository.findAll().stream().collect(Collectors.toList());
	 }
	 
	 @PostMapping("/invoice")
	 public Map<String, Set<String>> saveInvocie(@Valid @RequestBody Invoice invoice) {
		 Map<String, Set<String>> errors = new HashMap<>();
		 
		 Optional<Invoice> invoiceByIdList = invoiceRepository.findByInvoiceId(invoice.getId());
		 
		 Optional<Invoice> invoiceBySupplierBusinessId = invoiceRepository.findBySupplierBusinessId(invoice.getSupplierBusinessId());
		 
		 Optional<Invoice> invoiceByRetailerBusinessId = invoiceRepository.findByRetailerBusinessId(invoice.getRetailerBusinessId());
		 
		 System.out.println("Lot: " + invoice.getRetailerBusinessId() );
		 System.out.println("SupplierBusinessId: " + invoice.getSupplierBusinessId());
		 System.out.println("Total Amount: " + invoice.getTotalAmount() );
		 
		 invoiceRepository.save(invoice);
		 
		 return errors;		 		 
	 }
	 
}

