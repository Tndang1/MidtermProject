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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String lName;
	private LocalDateTime birthdate;
	@Column(name="create_date")
	private LocalDateTime createDate;
	@Column(name="customer_image")
	private String customerImage;
	private String bio;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="payment_info_id")
	private PaymentInfo paymentInfo;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="favorites", joinColumns = @JoinColumn(name="customer_id"), inverseJoinColumns = @JoinColumn(name="wine_id"))
	private List<Wine> wines;
	
	@OneToMany(mappedBy = "customer")
	private List<CustomerOrder> customerOrders;
	
	@OneToMany(mappedBy="customer")
	private List<Review> reviews;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public LocalDateTime getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public String getCustomerImage() {
		return customerImage;
	}
	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Wine> getWines() {
		return wines;
	}
	public void setWines(List<Wine> wines) {
		this.wines = wines;
	}
	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}
	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	//ADD/REMOVE methods:
	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		if (! reviews.contains(review)) {
			review.setCustomer(this);
			review.getWine().addReview(review);
			reviews.add(review);
		}
	}
	public void removeReview(Review review) {
		review.setCustomer(null);
		if (reviews != null) {
			reviews.remove(review);
		}
	}
	public void addWineToFavorites(Wine wine) {
		if (wines == null) {
			wines = new ArrayList<>();
		}
		if (! wines.contains(wine)) {
			wines.add(wine);
			wine.addCustomer(this);
		}
	}
	public void removeWineToFavorites(Wine wine) {
		if (wines != null && wines.contains(wine)) {
			wines.remove(wine);
			wine.removeCustomer(this);
		}
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
