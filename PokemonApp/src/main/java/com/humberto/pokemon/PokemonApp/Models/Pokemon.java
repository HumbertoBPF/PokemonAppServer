package com.humberto.pokemon.PokemonApp.Models;

import static com.humberto.pokemon.PokemonApp.Util.Tools.listOfTypesAsString;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.humberto.pokemon.PokemonApp.Enums.Gender;

@Entity
public class Pokemon {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double height;
	private Double weight;
	private Gender gender;
	@ManyToMany
	private List<Type> type;
	private String category;
	private Integer attack;
	private Integer defense;
	private Integer spAttack;
	private Integer spDefense;
	private Integer speed;
	private Integer hp;
	@ManyToMany
	private List<Move> moves;
	private Integer accuracy = 100;
	private Integer evasion = 0;
	
	public Pokemon() {
	}
	
	public Pokemon(Long id, String name, String description, Double height, Double weight, Gender gender,
			String category, Integer attack, Integer defense, Integer spAttack, Integer spDefense,
			Integer speed, Integer hp) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.category = category;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.hp = hp;
	}

	public Pokemon(String name, String description, Double height, Double weight, Gender gender, String category,
			Integer attack, Integer defense, Integer spAttack, Integer spDefense, Integer speed, Integer hp) {
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.category = category;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.hp = hp;
	}

	public Pokemon(String name, String description, Double height, Double weight, Gender gender, List<Type> type,
			String category, Integer attack, Integer defense, Integer spAttack, Integer spDefense, Integer speed,
			Integer hp, List<Move> moves) {
		super();
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.type = type;
		this.category = category;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.hp = hp;
		this.moves = moves;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getSpAttack() {
		return spAttack;
	}

	public void setSpAttack(Integer spAttack) {
		this.spAttack = spAttack;
	}

	public Integer getSpDefense() {
		return spDefense;
	}

	public void setSpDefense(Integer spDefense) {
		this.spDefense = spDefense;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	public Integer getEvasion() {
		return evasion;
	}

	public void setEvasion(Integer evasion) {
		this.evasion = evasion;
	}
	
	public String toStringTypes() {
		return listOfTypesAsString(this.getType());
	}
	
}
