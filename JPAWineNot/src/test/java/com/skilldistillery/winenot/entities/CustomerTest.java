package com.skilldistillery.winenot.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Customer customer;

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
		customer = em.find(Customer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	void test_customer_mapping() {
		assertNotNull(customer);
		assertEquals("Charles", customer.getfName());
		assertEquals("Dickens", customer.getlName());
		assertEquals("Sad boi.", customer.getBio());
		assertEquals(1812, customer.getBirthdate().getYear());
		assertEquals(02, customer.getBirthdate().getMonthValue());
		assertEquals(06, customer.getBirthdate().getDayOfMonth());
		assertEquals(1870, customer.getCreateDate().getYear());
		assertEquals(06, customer.getCreateDate().getMonthValue());
		assertEquals(7, customer.getCreateDate().getDayOfMonth());
		assertEquals("admin", customer.getUser().getUsername());
		assertEquals("admin", customer.getUser().getPassword());
		assertEquals(1, customer.getUser().getEnabled());
		assertEquals("admin", customer.getUser().getRole());
		
	}

}
