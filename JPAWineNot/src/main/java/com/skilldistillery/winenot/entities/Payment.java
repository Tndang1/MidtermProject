package com.skilldistillery.winenot.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
//	FIELDS===============================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int complete;
	@Column(name="order_id")
	private int orderId;
	@Column(name="payment_date")
	private LocalDateTime paymentDate;

	//	GETTERS AND SETTERS=================================

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
//	CONTRUCTORS===================================
	
	public Payment() {
		super();
	}
	
//  HASHCODE AND EQUALS ++++++++++++++++++++++++++++++++++++
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + complete;
		result = prime * result + id;
		result = prime * result + orderId;
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (complete != other.complete)
			return false;
		if (id != other.id)
			return false;
		if (orderId != other.orderId)
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		return true;
	}
//	TO STRING+++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public String toString() {
		return "Payment [id=" + id + "]";
	}
	
}
