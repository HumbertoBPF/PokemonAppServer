package com.humberto.pokemon.PokemonApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Models.Move;

public interface MoveRepository extends JpaRepository<Move, Long>{

}
