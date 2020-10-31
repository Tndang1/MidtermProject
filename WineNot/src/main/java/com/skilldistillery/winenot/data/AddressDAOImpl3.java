package com.skilldistillery.winenot.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Address;
import com.skilldistillery.winenot.entities.Customer;

@Service
@Transactional
public class AddressDAOImpl3 implements AddressDAO3 {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineNotPU");
	@PersistenceContext
	private static EntityManager em = emf.createEntityManager();
	
	@Override
	public Address create(Address address) {
		em.getTransaction().begin();
		
		em.persist(address);

		em.flush();
		
		em.getTransaction().commit();
		em.close();
		
		return address;
	}

	@Override
	public Address update(int id, Address address) {
		
		Address dbAddress = em.find(Address.class,  id);
		
		em.getTransaction().begin();
		
		dbAddress.setStreet(address.getStreet());
		dbAddress.setStreet2(address.getStreet2());
		dbAddress.setCity(address.getCity());
		dbAddress.setState(address.getState());
		dbAddress.setZip(address.getZip());
		dbAddress.setCountry(address.getCountry());
		
		em.flush();
		
		em.getTransaction().commit();
		
		em.close();
		return dbAddress;
	}

	@Override
	public boolean destroy(int id) {
		
		Address deleteAddress = em.find(Address.class, id);
		
		em.getTransaction().begin();
		em.remove(deleteAddress);
		
		boolean addressDeleted = ! em.contains(deleteAddress);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		return addressDeleted;
	}
//
	@Override
	public Address createAddressAndCustomer(Address address, Customer customer) {
//		
//		Language l = em.find(Language.class, 1);
//		customer.setLanguage(l);;
//		address.addFilm(customer);
//		
//		em.getTransaction().begin();
//		em.persist(address);
//		em.getTransaction().commit();
//		
//		em.close();
		return address;
	}

//	@Override
//	public Address findAddressById(int addressId) {
//		String sql = "SELECT id, street, street2, city, state, zip, country FROM address WHERE id = ?";
//		
//		
////		return em.createQuery(sql, Address.class).getResultList();
//	}

}

//public Actor findActorById(int actorId) {
//Actor actor = null;
////...
//String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
//PreparedStatement stmt = conn.prepareStatement(sql);
//stmt.setInt(1,actorId);
//ResultSet actorResult = stmt.executeQuery();
//if (actorResult.next()) {
//  actor = new Actor(); // Create the object
//  // Here is our mapping of query columns to our object fields:
//  actor.setId(actorResult.getInt(1));
//  actor.setFirstName(actorResult.getString(2));
//  actor.setLastName(actorResult.getString(3));
//}
////...
//return actor;
//}




