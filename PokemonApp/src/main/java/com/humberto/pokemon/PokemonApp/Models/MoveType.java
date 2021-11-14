package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.humberto.pokemon.PokemonApp.Models.Embeddable.MoveTypeId;

@Entity
@Table(name="move_type")
public class MoveType {
	
	@EmbeddedId
	private MoveTypeId id;
	
	public MoveType() {
	}
	
	public MoveType(MoveTypeId id) {
		this.id = id;
	}

	public MoveTypeId getId() {
		return id;
	}

	public void setId(MoveTypeId id) {
		this.id = id;
	}
	
}
