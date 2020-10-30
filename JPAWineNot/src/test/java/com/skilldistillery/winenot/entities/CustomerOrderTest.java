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

class CustomerOrderTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private CustomerOrder order;

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
		order = em.find(CustomerOrder.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		
	}
	
	@Test
	void test_Order_entity_fields() {
		assertNotNull(order);
		assertEquals(1, order.getId());
		LocalDateTime od = order.getOrderDate();
		assertEquals(2020, od.getYear());
		assertEquals(129.99, order.getAmount());
	}
	@Test
	void test_customer_customerOrder_relationship() {
		assertNotNull(order);
		assertEquals("Charles", order.getCustomer().getfName());
		
	}
	@Test
	void test_customerorder_orderwine_relationship() {
		assertNotNull(order);
		assertEquals(6, order.getWines().size());
	}
}
