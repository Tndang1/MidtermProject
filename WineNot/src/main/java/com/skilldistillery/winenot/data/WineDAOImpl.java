package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.Wine;
import com.skilldistillery.winenot.entities.WineColor;
import com.skilldistillery.winenot.entities.WineType;

@Service 
@Transactional
public class WineDAOImpl implements WineDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Wine findWineById(int id) {
	
		return em.find(Wine.class, id);
	}

	@Override
	public List<Wine> findAllWine() {
		String jpql = "SELECT w FROM Wine w";
		return em.createQuery(jpql, Wine.class).getResultList();
	}

	@Override
	public List<Wine> findWineByName(String labelName) {
		String jpql = "SELECT w FROM Wine w WHERE w.labelName = :labelName";
		
		return em.createQuery(jpql, Wine.class)
				.setParameter("labelName", labelName)
				.getResultList();
	}

	@Override
	public List<WineType> findWineByWineType(String wineType) {
		String jpql = "SELECT wt FROM WineType wt WHERE wt.wineType = :wineType";
		return em.createQuery(jpql, WineType.class)
				.setParameter("wineType", wineType)
				.getResultList();
	}

	@Override
	public List<WineColor> findWineByWineColor(String wineColor) {
		String jpql = "SELECT wc FROM WineColor wc WHERE wc.wineColor = :wineColor";
		return em.createQuery(jpql, WineColor.class)
				.setParameter("wineColor", wineColor)
				.getResultList();
	}

	@Override
	public List<Review> displayListOfReviews(String review) {
		String jpql = "SELECT r FROM Review r";
		return em.createQuery(jpql, Review.class).getResultList();
	}

	@Override
	public Wine createWine(Wine wine) {
		em.persist(wine);
		em.flush();
		return wine;
	}

	@Override
	public Wine updateWine(Wine wine) {
		Wine updateWine = em.find(Wine.class, wine.getId());
		updateWine.setLabelName(wine.getLabelName());
		updateWine.setVineyard(wine.getVineyard());
		updateWine.setVintageYear(wine.getVintageYear());
		updateWine.setFlavor(wine.getFlavor());
		updateWine.setDietary(wine.getDietary());
		updateWine.setDescription(wine.getDescription());
		updateWine.setImage(wine.getImage());
		updateWine.setPairs(wine.getPairs());
		updateWine.setWineColor(wine.getWineColor());
		updateWine.setWineType(wine.getWineType());
		return wine;
	}

	@Override
	public void deleteWine(int id) {
		String jpql = "DELETE FROM Wine w WHERE w.id = :id";
		id = em.createQuery(jpql)
				.setParameter("id", id)
				.executeUpdate();
		em.flush();
		
	}
	


}
