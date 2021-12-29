package com.humberto.pokemon.PokemonApp.Models.Embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TypeNotEffectiveId implements Serializable{

	@Column(name="type_id")
	private long typeId;
	@Column(name="not_effective_id")
	private long notEffectiveId;
	
	public TypeNotEffectiveId() {
	}

	public TypeNotEffectiveId(long typeId, long notEffectiveId) {
		this.typeId = typeId;
		this.notEffectiveId = notEffectiveId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getNotEffectiveId() {
		return notEffectiveId;
	}

	public void setNotEffectiveId(long notEffectiveId) {
		this.notEffectiveId = notEffectiveId;
	}
	
}
