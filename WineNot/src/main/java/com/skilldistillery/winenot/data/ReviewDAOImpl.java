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
	public List<Review> getAllReviews(ReviewId id) {
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
	public Review updateReview(ReviewId id, Review review) {
		Review dbReview = em.find(Review.class, id);
		dbReview.setImage(review.getImage());
		dbReview.setRating(review.getRating());
		dbReview.setReview(review.getReview());
		return null;
	}

	@Override
	public boolean deleteReview(ReviewId id) {
		Review reviewToDelete = em.find(Review.class, id);
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
