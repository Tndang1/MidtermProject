package com.skilldistillery.winenot.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Review {
	@EmbeddedId
	private ReviewId id;
	private String image;
	private int rating;
	private String review;
	@ManyToOne
	@JoinColumn(name="customer_id")
	@MapsId(value = "customerId")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="wine_id")
	@MapsId(value = "wineId")
	private Wine wine;
	
	public String getImage() {
		System.out.println(wine);
		System.out.println(image);
		if(image == null || image.trim().equals("")) {
			return wine.getImage();
		}
		return image;
	}
			
		
	public void setImage(String image) {
		this.image = image;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Wine getWine() {
		return wine;
	}
	public void setWine(Wine wine) {
		this.wine = wine;
	}
	public ReviewId getId() {
		return id;
	}
	public void setId(ReviewId id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((wine == null) ? 0 : wine.hashCode());
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
		Review other = (Review) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (wine == null) {
			if (other.wine != null)
				return false;
		} else if (!wine.equals(other.wine))
			return false;
		return true;
	}
	
}
