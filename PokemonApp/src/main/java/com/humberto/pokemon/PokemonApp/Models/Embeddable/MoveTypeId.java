package com.humberto.pokemon.PokemonApp.Models.Embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MoveTypeId implements Serializable{

	@Column(name = "move_id")
	private long moveId;
	@Column(name = "type_id")
	private long typeId;
	
	public MoveTypeId() {
	}

	public MoveTypeId(long moveId, long typeId) {
		this.moveId = moveId;
		this.typeId = typeId;
	}

	public long getMoveId() {
		return moveId;
	}

	public void setMoveId(long moveId) {
		this.moveId = moveId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
}
