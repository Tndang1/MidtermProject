package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.Wine;

public interface CustomerOrderDAO {

	CustomerOrder findById(int id); 
	
	public CustomerOrder create(CustomerOrder order); 
	
	public CustomerOrder update(int id, CustomerOrder order); 
	
	public boolean deleteCustomerOrder(int id); 
	
	List<CustomerOrder> findAll(); 
	
	public Wine addWineToOrder(int id, Wine wine); 
	
	public boolean removeWineFromOrder(int id, Wine wine); 
}
