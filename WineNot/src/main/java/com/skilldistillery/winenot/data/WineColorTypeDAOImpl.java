package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.WineColor;
import com.skilldistillery.winenot.entities.WineType;
@Service 
@Transactional
public class WineColorTypeDAOImpl implements WineColorTypeDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<WineColor> findWineByWineColor(String wineColor) {
		String jpql = "SELECT wc FROM WineColor wc WHERE wc.wineColor = :wineColor";
		return em.createQuery(jpql, WineColor.class)
				.setParameter("wineColor", wineColor)
				.getResultList();
	}
	@Override
	public WineColor findColorById(int id) {
		String jpql = "SELECT wc FROM WineColor wc WHERE wc.id = :id";
		return em.createQuery(jpql, WineColor.class).setParameter("id", id).getSingleResult();
	}
	@Override
	public WineType findTypeById(int id) {
		String jpql = "SELECT wt FROM WineType wt WHERE wt.id = :id";
		return em.createQuery(jpql, WineType.class).setParameter("id", id).getSingleResult();
	}
}
