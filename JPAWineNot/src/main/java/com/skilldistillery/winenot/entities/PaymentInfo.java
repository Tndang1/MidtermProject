package com.skilldistillery.winenot.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_info")
public class PaymentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="address_id")
	private int addressId;
	
	@Column(name="card_number")
	private int cardNumber;
	
	@Column(name="expr_date")
	LocalDateTime exprDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDateTime getExprDate() {
		return exprDate;
	}

	public void setExprDate(LocalDateTime exprDate) {
		this.exprDate = exprDate;
	}

	public PaymentInfo() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentInfo [id=");
		builder.append(id);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", exprDate=");
		builder.append(exprDate);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		PaymentInfo other = (PaymentInfo) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	

}
