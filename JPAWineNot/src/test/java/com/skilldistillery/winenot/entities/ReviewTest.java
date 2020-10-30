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

class ReviewTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Review review;
	private Customer customer;
	private Wine wine;

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
	void test_review_mapping() {
		String jpql = "SELECT review FROM Review review WHERE customer_id = 1 AND wine_id = 1";
		review = em.createQuery(jpql, Review.class).getSingleResult();
		assertNotNull(review);
		assertEquals(5, review.getRating());
		assertEquals("Tasty and great.", review.getReview());
		wine = review.getWine();
		assertEquals("Kendall-Jackson Vintner's Reserve", wine.getLabelName());
		customer = review.getCustomer();
		assertEquals("Charles", customer.getfName());
	}
}
