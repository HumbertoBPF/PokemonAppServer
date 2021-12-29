package com.humberto.pokemon.PokemonApp.Models.Embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PokemonMoveId implements Serializable{

	@Column(name="pokemon_id")
	private long pokemonId;
	@Column(name="moves_id")
	private long moveId;
	
	public PokemonMoveId() {
	}

	public PokemonMoveId(long pokemonId, long moveId) {
		this.pokemonId = pokemonId;
		this.moveId = moveId;
	}

	public long getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(long pokemonId) {
		this.pokemonId = pokemonId;
	}

	public long getMoveId() {
		return moveId;
	}

	public void setMoveId(long moveId) {
		this.moveId = moveId;
	}
	
}
