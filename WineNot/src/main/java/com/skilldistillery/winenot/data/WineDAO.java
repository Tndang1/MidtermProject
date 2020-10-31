package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.Wine;
import com.skilldistillery.winenot.entities.WineColor;
import com.skilldistillery.winenot.entities.WineType;

public interface WineDAO {
	
	public Wine findWineById(int id);
	public List<Wine> findAllWine();
	public List<Wine> findWineByName(String labelName);
	
	public List<WineType> findWineByWineType(String wineType);
	public List<WineColor> findWineByWineColor(String wineColor);
	
	public List<Review> displayListOfReviews(String review);
	
	public Wine createWine(Wine wine);
	public Wine updateWine(Wine wine);
	public void deleteWine(int id);

}
