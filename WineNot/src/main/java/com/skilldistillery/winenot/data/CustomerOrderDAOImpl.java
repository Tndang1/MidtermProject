package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.CustomerOrder;
import com.skilldistillery.winenot.entities.Wine;

@Service
@Transactional
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CustomerOrder findById(int id) {
		return em.find(CustomerOrder.class, id);
	}

	@Override
	public CustomerOrder create(CustomerOrder order) {
		em.persist(order);
		em.flush();
		em.close();
		return order;
	}

	@Override
	public CustomerOrder update(int id, CustomerOrder order) {
		CustomerOrder updateOrder = em.find(CustomerOrder.class, id);
		
		updateOrder.setOrderDate(order.getOrderDate());		
		updateOrder.setAmount(order.getAmount());
		updateOrder.setSize(order.getSize());
		
		return updateOrder;
	}

	@Override
	public boolean deleteCustomerOrder(int id) {
		CustomerOrder deleteOrder = em.find(CustomerOrder.class, id);
		em.remove(deleteOrder);
		boolean orderWasDeleted = !em.contains(deleteOrder);
		return orderWasDeleted;
	}

	@Override
	public List<CustomerOrder> findAll() {
		String jpql = "Select c FROM CustomerOrder c";
		return em.createQuery(jpql, CustomerOrder.class).getResultList();
	}

	@Override
	public Wine addWineToOrder(int id, Wine wine) {
		CustomerOrder dbOrder = em.find(CustomerOrder.class, id);
		dbOrder.addWine(wine);
		em.flush();
		em.close();
		return wine;
	}

	@Override
	public boolean removeWineFromOrder(int id, int wineId) {
		CustomerOrder dbOrder = em.find(CustomerOrder.class, id);
		Wine wine = em.find(Wine.class, wineId);
		dbOrder.removeWine(wine);
		em.flush();
		boolean removed = !dbOrder.getWines().contains(wine);
		em.close();
		return removed;
	}

}
