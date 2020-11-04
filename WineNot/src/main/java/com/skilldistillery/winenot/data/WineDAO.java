package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.Review;
import com.skilldistillery.winenot.entities.Wine;


public interface WineDAO {
	
	public Wine findWineById(int id);
	public List<Wine> findAllWine();
	public List<Wine> findAllEnabledWine();
	public List<Wine> findAllDisabledWine();
	public List<Wine> findWineByName(String labelName);
	
//	public List<WineType> findWineByWineType(String wineType);
	public List<Wine> findWineTypeId(int id);
	
//	public List<WineColor> findWineByWineColor(String wineColor);
	public List<Wine> findWineByWineColorId(int id);
	
//	public List<Review> displayListOfReviews(Review review);
	public List<Review> getCustomerReviews(int id);
	
	public Wine createWine(Wine wine);
	public Wine updateWine(Wine wine);
	public void deleteWine(int id);
	public boolean disableWine(int id);
	public boolean enableWine(int id);

}
