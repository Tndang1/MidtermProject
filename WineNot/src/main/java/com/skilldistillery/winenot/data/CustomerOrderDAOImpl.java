package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.CustomerOrder;

@Service
@Transactional
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineNotPU");

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

}
