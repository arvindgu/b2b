package com.chocopay.invoice;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
	
	
	@Column (name = "supplier_business_id")
	private int supplierBusinessId;
	
	@Column (name = "retailer_business_id")
	private int retailerBusinessId;
	
	@Column (name = "total_amount")
	private double totalAmount;
	
	@OneToMany(fetch=FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="invoice_id")
	@Fetch(FetchMode.SELECT)
	List<Goods> goodsList = new ArrayList<Goods>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSupplierBusinessId() {
		return supplierBusinessId;
	}

	public void setSupplierBusinessId(int supplierBusinessId) {
		this.supplierBusinessId = supplierBusinessId;
	}
	
	
	public int getRetailerBusinessId() {
		return retailerBusinessId;
	}

	public void setRetailerBusinessId(int retailerBusinessId) {
		this.retailerBusinessId = retailerBusinessId;
	}
	
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Goods> getGoodsList(){
		return goodsList;
	}
    
	public void setGoodsList(List<Goods> goodsList){
		this.goodsList = goodsList;
	}
}
