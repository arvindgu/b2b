package com.chocopay.invoice;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class InvoiceRepositoryTest {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	 public void invoice() {
		 
		 //InvoiceRepository mockRepository = Mockito.mock(InvoiceRepository.class);
		 //Invoice invoice = Mockito.mock(Invoice.class);
		
		 Invoice invoice = new Invoice();
		 
		 invoice.setRetailerBusinessId(1);
		 invoice.setSupplierBusinessId(2);
		 invoice.setTotalAmount(100.22);
		 
		 invoiceRepository.save(invoice);
		 
	 }
	

}
