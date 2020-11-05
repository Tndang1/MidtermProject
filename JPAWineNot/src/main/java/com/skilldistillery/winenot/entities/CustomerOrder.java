package com.skilldistillery.winenot.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="customer_order")
public class CustomerOrder {
// FIELDS========================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@CreationTimestamp
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	private double amount;
	
	private int size;
	private int processed;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="order_wine", joinColumns = @JoinColumn(name="order_id"), inverseJoinColumns = @JoinColumn(name="wine_id"))
	private List<Wine> wines;
	
//	GETTERS AND SETTERS ============================================

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public CustomerOrder() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Wine> getWines() {
		return wines;
	}

	public void setWines(List<Wine> wines) {
		this.wines = wines;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", size=");
		builder.append(size);
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
		CustomerOrder other = (CustomerOrder) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
// ADD AND REMOVE
	public void addWine(Wine wine) {
		if (wines == null) {
			wines = new ArrayList<Wine>();
		}
		if (!wines.contains(wine)) {
			wines.add(wine);
			wine.addCustomerOrder(this);
		}
	}
	public void removeWine(Wine wine) {
		if (wines != null && wines.contains(wine)) {
			wines.remove(wine);
			wine.removeCustomerOrder(this);
		}
	}

	public int getProcessed() {
		return processed;
	}

	public void setProcessed(int processed) {
		this.processed = processed;
	}
	
//	public void addFilm(Film film) {
//		if (films == null) {
//			films = new ArrayList<Film>();
//		}
//		if (!films.contains(film)) {
//			films.add(film);
//			film.addActor(this);
//		}
//	}
//	
//	public void removeFilm(Film film) {
//		if (films != null && films.contains(film)) {
//			films.remove(film);
//			film.removeFilm(this);
//		}
//	}
}
