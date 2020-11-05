package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.PaymentInfo;
import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.Wine;

public interface CustomerDAO {
	Customer getCustomerById(int id);
	Customer verifyLogin(String email, String password);
	List<Customer> getAllCustomers();
	Customer createCustomer(Customer customer);
	Customer updateCustomer(int id, Customer customer);
	boolean deleteCustomer(int id);
	List<Wine> getCustomerFavorites(int id);
	List<CustomerOrder> getCustomerOrders(int id);
	List<Review> getCustomerReviews(int id);
	List<Wine> addWineToFavorites(int id, int wid);
	Customer setAddress(int id, Address address);
	Customer setPayment(int id, PaymentInfo payInfo);
	boolean removeWineFromFavorites (int id, int wid);
}