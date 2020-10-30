package com.skilldistillery.winenot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Payment payment;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("WineNotPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		payment = em.find(Payment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_Payment_entity_fields() {
		LocalDateTime pd = payment.getPaymentDate();
		assertNotNull(payment);
		assertEquals(1, payment.getComplete());
		assertEquals(2020, pd.getYear());
		assertEquals(01, pd.getMonthValue());
		assertEquals(01, pd.getDayOfMonth());
	}
	@Test
	void test_payment_customerorder_relationship() {
		assertNotNull(payment);
		assertEquals(129.99, payment.getCustomerOrder().getAmount());
	}

}
