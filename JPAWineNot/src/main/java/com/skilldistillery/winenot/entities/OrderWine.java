package com.skilldistillery.winenot.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity 
@Table(name = "order_wine")
public class OrderWine {
	@EmbeddedId 
	private OrderWineId id;
	
//	@Column(name = "order_id")
//	private int orderId;
//	
//	
//	@Column(name = "wine_id")
//	private int wineId;
	
	private int quantity;
	
	
	

	public OrderWine() {
		super();
	}




//	public int getOrderId() {
//		return orderId;
//	}
//
//
//
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//
//
//
//	public int getWineId() {
//		return wineId;
//	}
//
//
//
//
//	public void setWineId(int wineId) {
//		this.wineId = wineId;
//	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}








	@Override
	public String toString() {
		return "OrderWine [id=" + id + ", quantity=" + quantity + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OrderWine other = (OrderWine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}





	
	
	

}
