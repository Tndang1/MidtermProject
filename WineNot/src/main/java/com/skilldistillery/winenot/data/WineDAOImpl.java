package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Customer;
import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.Wine;

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
	public List<Wine> findAllEnabledWine(){
		String jpql = "SELECT w FROM Wine w WHERE w.enabled = 1";
		return em.createQuery(jpql, Wine.class).getResultList();
	}
	
	@Override
	public List<Wine> findAllDisabledWine(){
		String jpql = "SELECT w FROM Wine w WHERE w.enabled = 0";
		return em.createQuery(jpql, Wine.class).getResultList();
	}
	@Override
	public List<Wine> findWineByName(String labelName) {
		String jpql = "SELECT w FROM Wine w WHERE w.labelName = :labelName AND w.enabled = 1";
		
		return em.createQuery(jpql, Wine.class)
				.setParameter("labelName", labelName)
				.getResultList();
	}


@Override
public List<Wine> findWineTypeId(int id) {
		String jpql = "SELECT w FROM Wine w WHERE w.wineType.id = :wineType AND w.enabled = 1";
		List<Wine> wineTypes = em.createQuery(jpql, Wine.class)
				.setParameter("wineType", id)
				.getResultList();
		em.close();
		return wineTypes;
}

@Override
public List<Wine> findWineByWineColorId(int id) {
		String jpql = "SELECT w FROM Wine w WHERE w.wineColor.id = :wineColor AND w.enabled = 1";
		List<Wine> wineColors = em.createQuery(jpql, Wine.class)
				.setParameter("wineColor", id)
				.getResultList();
		em.close();
	return wineColors;
}

	@Override
	public List<Review> getCustomerReviews(int id) {
		Wine wine = em.find(Wine.class, id);
		List<Review> reviews = wine.getReviews();
		em.close();
		return reviews;
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

	@Override
	public boolean disableWine(int id) {
		Wine wineToDisable = em.find(Wine.class, id);
		wineToDisable.setEnabled(0);
		boolean disabled = wineToDisable.getEnabled() < 1;
		em.flush();
		return disabled;
	}
	@Override
	public boolean enableWine(int id) {
		Wine wineToEnable = em.find(Wine.class, id);
		wineToEnable.setEnabled(1);
		boolean enabled = wineToEnable.getEnabled() > 0;
		em.flush();
		return enabled;
	}




	


}
