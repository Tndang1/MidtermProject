package com.skilldistillery.winenot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OrderWineId implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Column(name = "order_id")
	private int orderId;
	
	
	@Column(name = "wine_id")
	private int wineId;
	
//	private int quantity;
	
	
	

	public OrderWineId() {
		super();
	}




	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	public int getWineId() {
		return wineId;
	}




	public void setWineId(int wineId) {
		this.wineId = wineId;
	}



//
//	public int getQuantity() {
//		return quantity;
//	}
//
//
//
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}




	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}




	@Override
	public String toString() {
		return "OrderWineId [orderId=" + orderId + ", wineId=" + wineId + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderWineId other = (OrderWineId) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
	

}
