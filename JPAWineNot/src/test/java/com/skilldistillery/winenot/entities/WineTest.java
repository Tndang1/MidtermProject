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

class WineTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
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
		wine = em.find(Wine.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_wine_entity_fields_id_labelName_VintageYear() {
		
//		+----+-----------------------------------+---------------------------------+--------------+----------------------+---------+---------------------------------------------+------------------------------------------------------------------------------------------------------------------+----------------------+--------------+---------------+
//		| id | label_name                        | vineyard                        | vintage_year | flavor               | dietary | description                                 | image                                                                                                            | pairs                | wine_type_id | wine_color_id |
//		+----+-----------------------------------+---------------------------------+--------------+----------------------+---------+---------------------------------------------+------------------------------------------------------------------------------------------------------------------+----------------------+--------------+---------------+
//		|  1 | Kendall-Jackson Vintner's Reserve | Kendall-Jackson, California USA |         2018 | Semi-dry, refreshing | NULL    | Refreshing. Hint of toasted oak and butter. | https://www.kj.com/sites/default/files/styles/bottle_desktop/public/bottle-shots/kjvr-chard-nv.png?itok=gQhUHaDa | Fish, chicken, pasta |            1 |             2 |
//		+----+-----------------------------------+---------------------------------+--------------+----------------------+---------+---------------------------------------------+------------------------------------------------------------------------------------------------------------------+----------------------+--------------+---------------+
		

		assertNotNull(wine);
		assertEquals(1, wine.getId());
		assertEquals(2018, wine.getVintageYear());
		assertEquals("Kendall-Jackson Vintner's Reserve", wine.getLabelName());
		
	}
	@Test
	void test_wine_entity_fields_wine_color_id() {
		assertNotNull(wine);
		assertEquals(2, wine.getWineColor().getId());
		
	}
	@Test
	void test_wine_entity_fields_wine_type_id() {
		assertNotNull(wine);
		assertEquals(3, wine.getWineType().getId());
		
	}
	@Test
	void test_wine_to_customer_join() {
		assertNotNull(wine);
		assertEquals(1, wine.getCustomers().size());
	}
	@Test
	void test_wine_customerorder_relationship() {
		assertNotNull(wine);
		assertEquals(2, wine.getCustomerOrders().size());
	}
	@Test
	void test_wine_review_relationship() {
		assertNotNull(wine);
		assertEquals(1, wine.getReviews().size());
	}
	
	
}
