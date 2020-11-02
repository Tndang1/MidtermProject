package com.skilldistillery.winenot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="customer_id")
	private int customerId;
	@Column(name="wine_id")
	private int wineId;
	
	public ReviewId(int custId, int wineId) {
		this.customerId = custId;
		this.wineId = wineId;
	}
	
	public ReviewId() {
		
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getWineId() {
		return wineId;
	}
	public void setWineId(int wineId) {
		this.wineId = wineId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}