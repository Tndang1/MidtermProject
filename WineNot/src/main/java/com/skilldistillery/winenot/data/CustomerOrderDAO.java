package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.CustomerOrder;

public interface CustomerOrderDAO {

	CustomerOrder findById(int id);
	
	public CustomerOrder create(CustomerOrder order);
	
	public CustomerOrder update(int id, CustomerOrder order);
	
	public boolean deleteCustomerOrder(int id);
	
	List<CustomerOrder> findAll();
	
}
