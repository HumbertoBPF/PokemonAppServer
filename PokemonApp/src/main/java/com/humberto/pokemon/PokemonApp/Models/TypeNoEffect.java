package com.humberto.pokemon.PokemonApp.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.humberto.pokemon.PokemonApp.Models.Embeddable.TypeNoEffectId;

@Entity
@Table(name="type_no_effect")
public class TypeNoEffect {

	@EmbeddedId
	private TypeNoEffectId id;

	public TypeNoEffect() {
	}

	public TypeNoEffect(TypeNoEffectId typeNoEffectId) {
		this.id = typeNoEffectId;
	}

	public TypeNoEffectId getId() {
		return id;
	}

	public void setId(TypeNoEffectId id) {
		this.id = id;
	}
	
}
