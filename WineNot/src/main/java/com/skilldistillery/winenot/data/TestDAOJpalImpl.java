package com.skilldistillery.winenot.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.User;

@Service
@Transactional
public class TestDAOJpalImpl implements TestDAO{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User getTestUser() {
		return em.find(User.class,  1);
	}

	
	
}
