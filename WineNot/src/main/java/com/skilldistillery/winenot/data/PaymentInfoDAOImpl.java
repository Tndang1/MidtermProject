package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Payment;
import com.skilldistillery.winenot.entities.PaymentInfo;

@Transactional
@Service
public class PaymentInfoDAOImpl implements PaymentInfoDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineNotPU");

	@PersistenceContext
	private EntityManager em;

	@Override
	public PaymentInfo findById(int id) {
		return em.find(PaymentInfo.class, id);
	}

	@Override
	public PaymentInfo create(PaymentInfo payInfo) {
		
//		em.persist(address);
		em.persist(payInfo);
		em.flush();
		em.close();
		
		return payInfo;

	}

	@Override
	public PaymentInfo update(int id, PaymentInfo payInfo) {
		PaymentInfo updateInfo = em.find(PaymentInfo.class, id);

		updateInfo.setAddress(payInfo.getAddress());
		updateInfo.setCardNumber(payInfo.getCardNumber());
		updateInfo.setExprDate(payInfo.getExprDate());

		return updateInfo;
	}

	@Override
	public boolean deletePayInfo(int id) {
		PaymentInfo deleteInfo = em.find(PaymentInfo.class, id);

		em.remove(deleteInfo);

		boolean infoWasDeleted = !em.contains(deleteInfo);

		return infoWasDeleted;
	}

	@Override
	public List<PaymentInfo> findAll() {
		//PaymentInfo correct spelling? Note for future reference.
		String jpql = "Select p FROM PaymentInfo p ";
		return em.createQuery(jpql, PaymentInfo.class).getResultList();
	}
	@Override
	public PaymentInfo setAddress(int id, Address address) {
		PaymentInfo paymentInfo = em.find(PaymentInfo.class, id);
		paymentInfo.setAddress(address);
		return paymentInfo;
	}


}
