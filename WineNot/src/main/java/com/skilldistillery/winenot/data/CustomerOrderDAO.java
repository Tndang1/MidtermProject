package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.Wine;

public interface CustomerOrderDAO {

	public CustomerOrder findById(int id); 
	
	public CustomerOrder create(CustomerOrder order); 
	
	public CustomerOrder update(int id, CustomerOrder order); 
	
	public boolean deleteCustomerOrder(int id); 
	
	public List<CustomerOrder> findAll(); 
	
	public Wine addWineToOrder(int id, Wine wine); 
	
	public boolean removeWineFromOrder(int id, int wineId);

	public boolean removeAllWineFromOrder(List<Wine> wines, int custId); 
	
	public boolean processOrder(int orderId);
	public boolean unprocessOrder(int orderId);
}
