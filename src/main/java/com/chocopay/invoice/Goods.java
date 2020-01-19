package com.chocopay.invoice;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tax")
@EntityListeners(AuditingEntityListener.class)
public class Goods {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "rate")
	private double rate;
	
	@OneToMany(fetch=FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="tax_id")
	@Fetch(FetchMode.SELECT)
	List<Tax> taxList = new ArrayList<Tax>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
    
	public List<Tax> getTax(){
		return taxList;
	}
	
	public void setTax(List<Tax> taxList){
		this.taxList = taxList;
	}
}

