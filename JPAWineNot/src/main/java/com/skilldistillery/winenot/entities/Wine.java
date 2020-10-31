package com.skilldistillery.winenot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Wine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "label_name")
	private String labelName;
	private String vineyard;
	@Column(name = "vintage_year")
	private Integer vintageYear;
	private String flavor;
	private String dietary;
	private String description;
	private String image;
	private String pairs;

	@ManyToOne
	@JoinColumn(name = "wine_type_id")
	private WineType wineType;

	@ManyToOne
	@JoinColumn(name = "wine_color_id")
	private WineColor wineColor;

	@ManyToMany(mappedBy = "wines")
	private List<Customer> customers;
	
	@ManyToMany(mappedBy = "wines")
	private List<CustomerOrder> customerOrders;
	
	@OneToMany(mappedBy = "wine")
	private List<Review> reviews;
	
	public Wine() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getVineyard() {
		return vineyard;
	}
	public void setVineyard(String vineyard) {
		this.vineyard = vineyard;
	}
	public Integer getVintageYear() {
		return vintageYear;
	}
	public void setVintageYear(Integer vintageYear) {
		this.vintageYear = vintageYear;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getDietary() {
		return dietary;
	}
	public void setDietary(String dietary) {
		this.dietary = dietary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPairs() {
		return pairs;
	}
	public void setPairs(String pairs) {
		this.pairs = pairs;
	}
	public WineType getWineType() {
		return wineType;
	}
	public void setWineType(WineType wineType) {
		this.wineType = wineType;
	}
	public WineColor getWineColor() {
		return wineColor;
	}
	public void setWineColor(WineColor wineColor) {
		this.wineColor = wineColor;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}
	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	//ADD/REMOVE methods:
	public void addCustomer(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		if (! customers.contains(customer)) {
			customers.add(customer);
			customer.addWine(this);
		}
	}
	public void removeCustomer(Customer customer) {
		if (customers != null && customers.contains(customer)) {
			customers.remove(customer);
			customer.removeWine(this);
		}
	}
	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		if (! reviews.contains(review)) {
			review.setWine(this);
			reviews.add(review);
		}
	}
	public void removeReview(Review review) {
		review.setWine(null);
		if (reviews != null) {
			reviews.remove(review);
		}
	}
	public void addCustomerOrder(CustomerOrder customerOrder) {
		if (customerOrders == null) {
			customerOrders = new ArrayList<>();
		}
		if (! customerOrders.contains(customerOrder)) {
			customerOrders.add(customerOrder);
			customerOrder.addWine(this);
		}
	}
	public void removeCustomerOrder(CustomerOrder customerOrder) {
		if (customerOrders != null && customerOrders.contains(customerOrder)) {
			customerOrders.remove(customerOrder);
			customerOrder.removeWine(this);
		}
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", labelName=" + labelName + ", vineyard=" + vineyard + ", vintageYear=" + vintageYear
				+ ", flavor=" + flavor + ", dietary=" + dietary + ", description=" + description + ", image=" + image
				+ ", pairs=" + pairs + "]";
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
		Wine other = (Wine) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
