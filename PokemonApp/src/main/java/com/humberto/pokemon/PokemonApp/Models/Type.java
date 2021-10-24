package com.humberto.pokemon.PokemonApp.Models;

import static com.humberto.pokemon.PokemonApp.Util.Tools.listOfTypesAsString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Type {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany
	private List<Type> effective = new ArrayList<>();
	@ManyToMany
	private List<Type> notEffective = new ArrayList<>();
	@ManyToMany
	private List<Type> noEffect = new ArrayList<>();
	
	public Type() {
	}

	public Type(String name, List<Type> effective, List<Type> notEffective, List<Type> noEffect) {
		this.name = name;
		this.effective = effective;
		this.notEffective = notEffective;
		this.noEffect = noEffect;
	}
	
	public Type(Long id, String name, List<Type> effective, List<Type> notEffective, List<Type> noEffect) {
		this.id = id;
		this.name = name;
		this.effective = effective;
		this.notEffective = notEffective;
		this.noEffect = noEffect;
	}

	public Type(String name) {
		this.name = name;
	}

	public Type(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getEffective() {
		return effective;
	}

	public void setEffective(List<Type> effective) {
		this.effective = effective;
	}

	public List<Type> getNotEffective() {
		return notEffective;
	}

	public void setNotEffective(List<Type> notEffective) {
		this.notEffective = notEffective;
	}

	public List<Type> getNoEffect() {
		return noEffect;
	}

	public void setNoEffect(List<Type> noEffect) {
		this.noEffect = noEffect;
	}
	
	public String toStringEffectiveTypes() {
		return listOfTypesAsString(this.getEffective());
	}
	
	public String toStringNotEffectiveTypes() {
		return listOfTypesAsString(this.getNotEffective());
	}
	
	public String toStringNoEffectTypes() {
		return listOfTypesAsString(this.getNoEffect());
	}
	
}
