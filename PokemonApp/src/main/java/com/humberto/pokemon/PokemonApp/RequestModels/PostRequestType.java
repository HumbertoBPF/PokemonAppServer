package com.humberto.pokemon.PokemonApp.RequestModels;

import com.humberto.pokemon.PokemonApp.Models.Type;

public class PostRequestType {
	
	private Long fId;
	private String fName;
	
	public PostRequestType(Long fId, String fName) {
		this.fId = fId;
		this.fName = fName;
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
	
	public Type toType() {
		System.out.println(fName);
		if (fId == null) {
			return new Type(fName); 
		}
		return new Type(fId, fName);
	}
	
	public void fromType(Type type) {
		this.fId = type.getId();
		this.fName = type.getName();
	}
	
}
