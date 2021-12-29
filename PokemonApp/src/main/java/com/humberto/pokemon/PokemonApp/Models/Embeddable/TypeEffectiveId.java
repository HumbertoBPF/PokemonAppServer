package com.humberto.pokemon.PokemonApp.Models.Embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TypeEffectiveId implements Serializable{

	@Column(name="type_id")
	private long typeId;
	@Column(name="effective_id")
	private long effectiveId;
	
	public TypeEffectiveId() {
	}

	public TypeEffectiveId(long typeId, long effectiveId) {
		this.typeId = typeId;
		this.effectiveId = effectiveId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getEffectiveId() {
		return effectiveId;
	}

	public void setEffectiveId(long effectiveId) {
		this.effectiveId = effectiveId;
	}
	
}
