package com.humberto.pokemon.PokemonApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.PokemonType;

public interface PokemonTypeRepository extends JpaRepository<PokemonType, Long>{

}
