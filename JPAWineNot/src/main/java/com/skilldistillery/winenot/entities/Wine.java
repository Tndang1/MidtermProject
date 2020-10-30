package com.skilldistillery.winenot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Wine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "label_name")
	private String labelName;

	private String vineyard;
	@Column(name = "vintage_year")
	private Integer vintageYear;

	private String flavor;

	private String dietary;

	private String description;

	private String image;

	private String pairs;

	@ManyToOne
	@JoinColumn(name = "wine_type_id")
	private WineType wineType;

	@ManyToOne
	@JoinColumn(name = "wine_color_id")
	private WineColor wineColor;

	
	
	public Wine() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getVineyard() {
		return vineyard;
	}

	public void setVineyard(String vineyard) {
		this.vineyard = vineyard;
	}

	public Integer getVintageYear() {
		return vintageYear;
	}

	public void setVintageYear(Integer vintageYear) {
		this.vintageYear = vintageYear;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getDietary() {
		return dietary;
	}

	public void setDietary(String dietary) {
		this.dietary = dietary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPairs() {
		return pairs;
	}

	public void setPairs(String pairs) {
		this.pairs = pairs;
	}



	public WineType getWineType() {
		return wineType;
	}



	public void setWineType(WineType wineType) {
		this.wineType = wineType;
	}




	

	public WineColor getWineColor() {
		return wineColor;
	}



	public void setWineColor(WineColor wineColor) {
		this.wineColor = wineColor;
	}










	@Override
	public String toString() {
		return "Wine [id=" + id + ", labelName=" + labelName + ", vineyard=" + vineyard + ", vintageYear=" + vintageYear
				+ ", flavor=" + flavor + ", dietary=" + dietary + ", description=" + description + ", image=" + image
				+ ", pairs=" + pairs + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wine other = (Wine) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
