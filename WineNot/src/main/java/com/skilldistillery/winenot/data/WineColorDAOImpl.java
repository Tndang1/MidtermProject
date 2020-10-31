package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.WineColor;
@Service 
@Transactional
public class WineColorDAOImpl implements WineColorDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<WineColor> findWineByWineColor(String wineColor) {
		String jpql = "SELECT wc FROM WineColor wc WHERE wc.wineColor = :wineColor";
		return em.createQuery(jpql, WineColor.class)
				.setParameter("wineColor", wineColor)
				.getResultList();
	}

}
