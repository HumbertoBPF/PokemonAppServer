package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.humberto.pokemon.PokemonApp.Models.Embeddable.PokemonMoveId;

@Entity
@Table(name="pokemon_moves")
public class PokemonMove {

	@EmbeddedId
	private PokemonMoveId id;

	public PokemonMove() {
	}

	public PokemonMove(PokemonMoveId id) {
		this.id = id;
	}

	public PokemonMoveId getId() {
		return id;
	}

	public void setId(PokemonMoveId id) {
		this.id = id;
	}
	
}
