package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Address;

@Transactional
@Service
public class AddressDAOImpl implements AddressDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineNotPU");

	@PersistenceContext
	private EntityManager em;

	@Override
	public Address getAddressById(int id) {
		return em.find(Address.class, id);
	}

	@Override
	public List<Address> listAllAddresses() {
		String jpql = "Select a FROM Address a";
		return em.createQuery(jpql, Address.class).getResultList();
	}

	@Override
	public Address createAddress(Address address) {
		em.persist(address);
		em.flush();
		em.close();

		return address;
	}

	@Override
	public Address updateAddress(int id, Address address) {
		Address updateAddress = em.find(Address.class, id);

		updateAddress.setStreet(address.getStreet());
		updateAddress.setStreet2(address.getStreet2());
		updateAddress.setCity(address.getCity());
		updateAddress.setState(address.getState());
		updateAddress.setZip(address.getZip());
		updateAddress.setCountry(address.getCountry());
		em.close();
		return updateAddress;
	}

	@Override
	public boolean deleteAddress(int id) {
		Address deleteAddress = em.find(Address.class, id);

		em.remove(deleteAddress);

		boolean addressWasDeleted = !em.contains(deleteAddress);
		
		em.close();

		return addressWasDeleted;
	}

}
