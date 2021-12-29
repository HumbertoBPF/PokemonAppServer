package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.humberto.pokemon.PokemonApp.Models.Embeddable.TypeEffectiveId;

@Entity
@Table(name="type_effective")
public class TypeEffective {

	@EmbeddedId
	private TypeEffectiveId id;

	public TypeEffective() {
	}

	public TypeEffective(TypeEffectiveId id) {
		this.id = id;
	}

	public TypeEffectiveId getId() {
		return id;
	}

	public void setId(TypeEffectiveId id) {
		this.id = id;
	}
	
}
