package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.WineColor;

public interface WineColorDAO {
	public List<WineColor> findWineByWineColor(String wineColor);

}
