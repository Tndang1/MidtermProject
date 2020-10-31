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
		assertEquals(1870, customer.getCreateDate().getYear());
		assertEquals(06, customer.getCreateDate().getMonthValue());
		assertEquals("admin", customer.getUser().getUsername());
		assertEquals("admin", customer.getUser().getPassword());
		assertEquals(1, customer.getUser().getEnabled());
		assertEquals("admin", customer.getUser().getRole());
	}
	
	@Test
	void test_customer_address_mapping() {
		assertNotNull(customer);
		Address address = customer.getAddress();
		assertNotNull(address);
		assertEquals("800 Victor St", address.getStreet());
		assertNull(address.getStreet2());
	}
	
	@Test
	void test_customer_payment_info_mapping() {
		assertNotNull(customer);
		PaymentInfo paymentInfo = customer.getPaymentInfo();
		assertNotNull(paymentInfo);
		assertEquals("12345678", paymentInfo.getCardNumber());
		
	}
	
	@Test
	void test_customer_favorites_joining() {
		assertNotNull(customer);
		assertEquals(3, customer.getWines().size());
	}
	@Test
	void test_customer_customerorder_relationship() {
		assertNotNull(customer);
		assertEquals(1, customer.getCustomerOrders().size());
	}
	@Test
	void test_customer_review_relationship() {
		assertNotNull(customer);
		assertEquals(3, customer.getReviews().size());
	}
	
}
