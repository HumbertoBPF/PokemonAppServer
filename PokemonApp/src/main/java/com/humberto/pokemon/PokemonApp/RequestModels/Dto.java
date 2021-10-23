package com.humberto.pokemon.PokemonApp.RequestModels;

public abstract class Dto {

	public abstract Object toEntity();
	
	public abstract void fromEntity(Object entity);
	
}
