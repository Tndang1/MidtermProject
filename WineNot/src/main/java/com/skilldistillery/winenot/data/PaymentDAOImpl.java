package com.skilldistillery.winenot.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.Payment;

@Service
@Transactional 
public class PaymentDAOImpl implements PaymentDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Payment findById(int id) {
		return em.find(Payment.class, id);
	}
	
	@Override
	public Payment findPaymentByOrderId(int id) {
		String jpql = "SELECT p FROM Payment p WHERE p.customerOrder.id = :id";
		Payment payment = em.createQuery(jpql, Payment.class).setParameter("id", id).getSingleResult();
		em.close();
		return payment;
	}

	@Override
	public Payment createPayment(Payment payment) {
		em.persist(payment);
		em.flush();
		return payment;
	}

	@Override
	public Payment updatePayment(int id, Payment payment) {
		Payment updatePayment = em.find(Payment.class, id);
		updatePayment.setComplete(payment.getComplete());
		updatePayment.setId(payment.getId());
		updatePayment.setPaymentDate(payment.getPaymentDate());
		em.close();
		return updatePayment;
	}

	@Override
	public boolean deletePayment(int id) {
		String jpql = "SELECT p FROM Payment p WHERE p.id = :id";
		Payment payment = em.createQuery(jpql, Payment.class).setParameter("id", id).getSingleResult();
		em.remove(payment);
		boolean removed = !em.contains(payment);
		em.flush();
		em.close();
		return removed;
		
	}


}
