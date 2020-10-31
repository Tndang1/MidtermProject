package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.ReviewId;

public interface ReviewDAO {
	Review getReviewById(ReviewId id);
	List<Review> getAllReviews(ReviewId id);
	Review createReview(Review review);
	Review updateReview(ReviewId id, Review review);
	boolean deleteReview(ReviewId id);
	List<Review> getReviewsByRating(int rating);
	
}
