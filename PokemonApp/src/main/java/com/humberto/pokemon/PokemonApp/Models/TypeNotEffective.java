package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.humberto.pokemon.PokemonApp.Models.Embeddable.TypeNotEffectiveId;

@Entity
@Table(name="type_not_effective")
public class TypeNotEffective {

	@EmbeddedId
	private TypeNotEffectiveId id;

	public TypeNotEffective() {
	}

	public TypeNotEffective(TypeNotEffectiveId id) {
		this.id = id;
	}

	public TypeNotEffectiveId getId() {
		return id;
	}

	public void setId(TypeNotEffectiveId id) {
		this.id = id;
	}
	
}
