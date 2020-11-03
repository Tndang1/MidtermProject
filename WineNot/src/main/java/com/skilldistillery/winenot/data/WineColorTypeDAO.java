package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.WineColor;
import com.skilldistillery.winenot.entities.WineType;

public interface WineColorTypeDAO {
	public List<WineColor> findWineByWineColor(String wineColor);

	WineType findTypeById(int id);

	WineColor findColorById(int id);

}
