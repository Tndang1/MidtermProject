package com.skilldistillery.winenot.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.ReviewId;

@Service
@Transactional
public class ReviewDAOImpl implements ReviewDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Review getReviewById(ReviewId id) {
		Review review =	em.find(Review.class, id);
		return review;
	}
	
	@Override
	public Review getReviewByCustomerAndWineId(int custId, int wineId) {
		String jpql = "SELECT r from Review r where r.id.customerId = :custId AND r.id.wineId = :wineId";
		Review review = em.createQuery(jpql, Review.class).setParameter("custId", custId).setParameter("wineId", wineId).getSingleResult();
		return review;
	}

	@Override
	public List<Review> getAllReviews() {
		String jpql = "Select r FROM Review r";
		List<Review> reviews = em.createQuery(jpql, Review.class).getResultList();
		return reviews;
	}

	@Override
	public Review createReview(Review review) {
		em.persist(review);
		em.flush();
		em.close();
		return review;
	}
	
	@Override
	public Review updateReview(int custId, int wineId, Review review) {
		String jpql = "SELECT r from Review r where r.id.customerId = :custId AND r.id.wineId = :wineId";
		Review dbReview = em.createQuery(jpql, Review.class).setParameter("custId", custId).setParameter("wineId", wineId).getSingleResult();
		dbReview.setImage(review.getImage());
		dbReview.setRating(review.getRating());
		dbReview.setReview(review.getReview());
		return null;
	}

	@Override
	public boolean deleteReview(int custId, int wineId) {
		System.out.println(custId);
		System.out.println(wineId);
		String jpql = "SELECT r from Review r where r.id.customerId = :custId AND r.id.wineId = :wineId";
		Review reviewToDelete = em.createQuery(jpql, Review.class).setParameter("custId", custId).setParameter("wineId", wineId).getSingleResult();
		em.remove(reviewToDelete);
		boolean deleted = !em.contains(reviewToDelete);
		return deleted;
	}

	@Override
	public List<Review> getReviewsByRating(int ratingSearch) {
		List<Review> reviews = null;
		String jpql = "SELECT r FROM Review r where r.rating = :ratingSearch";
		reviews = em.createNamedQuery(jpql, Review.class).setParameter("ratingSearch", ratingSearch).getResultList();
		return reviews;
	}

}
