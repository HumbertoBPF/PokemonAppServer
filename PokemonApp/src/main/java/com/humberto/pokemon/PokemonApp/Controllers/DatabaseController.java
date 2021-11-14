package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humberto.pokemon.PokemonApp.Models.Move;
import com.humberto.pokemon.PokemonApp.Models.MoveType;
import com.humberto.pokemon.PokemonApp.Models.Pokemon;
import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.MoveTypeId;
import com.humberto.pokemon.PokemonApp.Repositories.MoveRepository;
import com.humberto.pokemon.PokemonApp.Repositories.MoveTypeRepository;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonRepository;
import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.MoveDto;
import com.humberto.pokemon.PokemonApp.RequestModels.PokemonDto;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

@RestController
public class DatabaseController {

	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private MoveRepository moveRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private MoveTypeRepository moveTypeRepository;
	
	@GetMapping("/PokemonApp/db/pokemon")
	public List<PokemonDto> getPokemons(){
		List<Pokemon> pokemons = pokemonRepository.findAll();
		List<PokemonDto> pokemonDtos = new ArrayList<>();
		for (Pokemon pokemon : pokemons) {
			PokemonDto pokemonDto = new PokemonDto();
			pokemonDto.fromEntity(pokemon);
			pokemonDtos.add(pokemonDto);
		}
		return pokemonDtos;
	}
	
	@GetMapping("/PokemonApp/db/moves")
	public List<MoveDto> getMoves(){
		List<Move> moves = moveRepository.findAll();
		List<MoveDto> moveDtos = new ArrayList<>();
		for (Move move : moves) {
			MoveDto moveDto = new MoveDto();
			moveDto.fromEntity(move);
			moveDtos.add(moveDto);
		}
		return moveDtos;
	}
	
	@GetMapping("/PokemonApp/db/types")
	public List<TypeDto> getTypes(){
		List<Type> types = typeRepository.findAll();
		List<TypeDto> typeDtos = new ArrayList<>();
		for (Type type : types) {
			TypeDto typeDto = new TypeDto();
			typeDto.fromEntity(type);
			typeDtos.add(typeDto);
		}
		return typeDtos;
	}
	
	@GetMapping("/PokemonApp/db/moveTypes")
	public List<MoveTypeId> getMoveType(){
		List<MoveType> moveTypes = moveTypeRepository.findAll();
		List<MoveTypeId> moveTypeIds = new ArrayList<>();
		for (MoveType moveType : moveTypes) {
			moveTypeIds.add(moveType.getId());
		}
		return moveTypeIds;
	}
	
}
