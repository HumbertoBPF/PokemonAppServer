package com.humberto.pokemon.PokemonApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
