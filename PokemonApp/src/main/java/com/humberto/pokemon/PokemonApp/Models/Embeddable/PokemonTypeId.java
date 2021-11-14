package com.humberto.pokemon.PokemonApp.Models.Embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PokemonTypeId implements Serializable{

	@Column(name="pokemon_id")
	private long pokemonId;
	@Column(name="type_id")
	private long typeId;
	
	public PokemonTypeId() {
	}

	public PokemonTypeId(long pokemonId, long typeId) {
		this.pokemonId = pokemonId;
		this.typeId = typeId;
	}

	public long getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(long pokemonId) {
		this.pokemonId = pokemonId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setMoveId(long typeId) {
		this.typeId = typeId;
	}
	
}
