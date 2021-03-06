package com.skilldistillery.winenot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderWineTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private OrderWine order;

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
		OrderWineId oid = new OrderWineId();
		oid.setOrderId(1);
		oid.setWineId(1);
		order = em.find(OrderWine.class, oid);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_orderwine_mapping() {
		String jpql = "SELECT order FROM OrderWine order "
				+ "WHERE order_id = 1 AND wine_id = 1";
		order = em.createQuery(jpql, OrderWine.class)
				.getSingleResult();
		assertNotNull(order);
		assertEquals(1, order.getQuantity());
		
		
	}

}
