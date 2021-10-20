package com.humberto.pokemon.PokemonApp.RequestModels;

import com.humberto.pokemon.PokemonApp.Enums.CategoryMove;
import com.humberto.pokemon.PokemonApp.Models.Move;

public class MoveDto {

	private Long fId;
	private String fName;
	private String fCategory;
	private Long fPower;
	private Integer fAccuracy;
	
	public MoveDto(Long fId, String fName, String fCategory, Long fPower, Integer fAccuracy) {
		this.fId = fId;
		this.fName = fName;
		this.fCategory = fCategory;
		this.fPower = fPower;
		this.fAccuracy = fAccuracy;
	}

	public Long getfId() {
		return fId;
	}
	
	public void setfId(Long fId) {
		this.fId = fId;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getfCategory() {
		return fCategory;
	}
	
	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
	}
	
	public Long getfPower() {
		return fPower;
	}
	
	public void setfPower(Long fPower) {
		this.fPower = fPower;
	}
	
	public Integer getfAccuracy() {
		return fAccuracy;
	}
	
	public void setfAccuracy(Integer fAccuracy) {
		this.fAccuracy = fAccuracy;
	}
	
	private CategoryMove toCategoryMove(String categoryMoveString) {
		if (categoryMoveString.equals(CategoryMove.PHYSICAL.getValue())) {
			return CategoryMove.PHYSICAL;
		}else if (categoryMoveString.equals(CategoryMove.SPECIAL.getValue())) {
			return CategoryMove.SPECIAL;
		}else if (categoryMoveString.equals(CategoryMove.STATUS.getValue())) {
			return CategoryMove.STATUS;
		}else {
			return null;
		}
	}
	
	public Move toMove() {
		if (fId == null) {
			return new Move(fName,toCategoryMove(fCategory),fPower,fAccuracy);
		}
		return new Move(fId,fName,toCategoryMove(fCategory),fPower,fAccuracy);
	}
	
	public void fromMove(Move move) {
		this.fId = move.getId();
		this.fName = move.getName();
		this.fCategory = move.getCategory().toString();
		this.fPower = move.getPower();
		this.fAccuracy = move.getAccuracy();
	}
	
}
