package com.humberto.pokemon.PokemonApp.RequestModels;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class Dto {

	public abstract Object toEntity(JpaRepository repository);
	
	public abstract void fromEntity(Object entity);
	
}
