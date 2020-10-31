package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.Review;

public interface CustomerDAO3 {
	public Customer create(Customer customer);
	public Customer update(int id, Customer customer);
	public boolean destroy(int id);
//	public Customer createAddressAndCustomer(Customer customer, Customer customer);
	
	public List<Review> reviews();
}






//crud, get list of reviews, customer orders, and wines