package com.humberto.pokemon.PokemonApp.Models.Embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TypeNoEffectId implements Serializable{

	@Column(name="type_id")
	private long typeId;
	@Column(name="no_effect_id")
	private long noEffectId;
	
	public TypeNoEffectId() {
	}

	public TypeNoEffectId(long typeId, long noEffectId) {
		this.typeId = typeId;
		this.noEffectId = noEffectId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getNoEffectId() {
		return noEffectId;
	}

	public void setNoEffectId(long noEffectId) {
		this.noEffectId = noEffectId;
	}
	
}
