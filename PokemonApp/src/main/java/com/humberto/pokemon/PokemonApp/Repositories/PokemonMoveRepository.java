package com.humberto.pokemon.PokemonApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.PokemonMove;

public interface PokemonMoveRepository extends JpaRepository<PokemonMove,Long>{

}
