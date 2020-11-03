package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.ReviewId;

public interface ReviewDAO {
	Review getReviewById(ReviewId id);
	Review getReviewByCustomerAndWineId(int custId, int wineId);
	List<Review> getAllReviews();
	Review createReview(Review review);
	Review updateReview(int custId, int wineId, Review review);
	boolean deleteReview(int custId, int wineId);
	List<Review> getReviewsByRating(int rating);
	
}
