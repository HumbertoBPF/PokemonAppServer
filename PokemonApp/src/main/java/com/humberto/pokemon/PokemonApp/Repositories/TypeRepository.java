package com.humberto.pokemon.PokemonApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
	Type getByName(String name);
}
