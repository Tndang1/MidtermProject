package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.WineType;

public interface WineTypeDAO {
	public List<WineType> findWineByWineType(String wineType);

}
