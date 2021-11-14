package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.humberto.pokemon.PokemonApp.Models.Embeddable.PokemonTypeId;

@Entity
@Table(name="pokemon_type")
public class PokemonType {

	@EmbeddedId
	private PokemonTypeId id;

	public PokemonType() {
	}

	public PokemonType(PokemonTypeId pokemonTypeId) {
		this.id = pokemonTypeId;
	}

	public PokemonTypeId getId() {
		return id;
	}

	public void setId(PokemonTypeId id) {
		this.id = id;
	}
	
}
