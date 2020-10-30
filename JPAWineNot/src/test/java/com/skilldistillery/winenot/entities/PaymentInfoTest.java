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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentInfoTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private PaymentInfo payInfo;

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
		payInfo = em.find(PaymentInfo.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Payment class junit test")
	void test1() {
		assertNotNull(payInfo);
		assertEquals(1, payInfo.getId());
		assertEquals(12345678, payInfo.getCardNumber());
		LocalDateTime ed = payInfo.getExprDate();
		assertEquals(1870, ed.getYear());
	}
	
	@Test
	void paymentInfo_to_address_relationship() {
		assertNotNull(payInfo);
		assertNotNull(payInfo.getAddress());
		assertEquals("800 Victor St", payInfo.getAddress().getStreet());
	}
}
