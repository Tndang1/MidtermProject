package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.WineType;
@Service 
@Transactional
public class WineTypeDAOImpl implements WineTypeDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<WineType> findWineByWineType(String wineType) {
		String jpql = "SELECT wt FROM WineType wt WHERE wt.wineType = :wineType";
		return em.createQuery(jpql, WineType.class)
				.setParameter("wineType", wineType)
				.getResultList();
	}

}
