package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineNotPU");

	@PersistenceContext
	private EntityManager em;

	@Override
	public User getUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "Select u FROM User u";
		return em.createQuery(jpql, User.class).getResultList();
	}

	@Override
	public User createUser(User user) {
		em.persist(user);
		em.flush();
		em.close();

		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		User updateUser = em.find(User.class, id);
		updateUser.setEmail(user.getEmail());
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(user.getPassword());
		updateUser.setEnabled(user.getEnabled());
		updateUser.setRole(user.getRole());

		return updateUser;
	}

	@Override
	public boolean deleteUser(int id) {
		User deleteUser = em.find(User.class, id);
		
		em.remove(deleteUser);
		
		boolean userWasDeleted = !em.contains(deleteUser);
	
		return userWasDeleted;
	}

	@Override
	public boolean disableUser(int id) {
		User userToDisable = em.find(User.class, id);
		userToDisable.setEnabled(0);
		boolean disabled = userToDisable.getEnabled() < 1;
		return disabled;
	}

	@Override
	public boolean enableUser(int id) {
		User userToEnable = em.find(User.class, id);
		userToEnable.setEnabled(1);
		boolean enabled = userToEnable.getEnabled() > 0;
		return enabled;
	}

}
