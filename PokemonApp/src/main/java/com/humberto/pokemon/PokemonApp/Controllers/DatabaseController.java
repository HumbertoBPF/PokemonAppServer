package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humberto.pokemon.PokemonApp.Models.Move;
import com.humberto.pokemon.PokemonApp.Models.MoveType;
import com.humberto.pokemon.PokemonApp.Models.Pokemon;
import com.humberto.pokemon.PokemonApp.Models.PokemonMove;
import com.humberto.pokemon.PokemonApp.Models.PokemonType;
import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Models.TypeEffective;
import com.humberto.pokemon.PokemonApp.Models.TypeNoEffect;
import com.humberto.pokemon.PokemonApp.Models.TypeNotEffective;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.MoveTypeId;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.PokemonMoveId;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.PokemonTypeId;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.TypeEffectiveId;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.TypeNoEffectId;
import com.humberto.pokemon.PokemonApp.Models.Embeddable.TypeNotEffectiveId;
import com.humberto.pokemon.PokemonApp.Repositories.MoveRepository;
import com.humberto.pokemon.PokemonApp.Repositories.MoveTypeRepository;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonMoveRepository;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonRepository;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonTypeRepository;
import com.humberto.pokemon.PokemonApp.Repositories.TypeEffectiveRepository;
import com.humberto.pokemon.PokemonApp.Repositories.TypeNoEffectRepository;
import com.humberto.pokemon.PokemonApp.Repositories.TypeNotEffectiveRepository;
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
	@Autowired
	private PokemonTypeRepository pokemonTypeRepository;
	@Autowired
	private TypeEffectiveRepository typeEffectiveRepository;
	@Autowired
	private TypeNotEffectiveRepository typeNotEffectiveRepository;
	@Autowired
	private TypeNoEffectRepository typeNoEffectRepository;
	@Autowired
	private PokemonMoveRepository pokemonMoveRepository;
	
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
	public List<MoveTypeId> getMoveTypes(){
		List<MoveType> moveTypes = moveTypeRepository.findAll();
		List<MoveTypeId> moveTypeIds = new ArrayList<>();
		for (MoveType moveType : moveTypes) {
			moveTypeIds.add(moveType.getId());
		} 
		return moveTypeIds;
	}
	
	@GetMapping("/PokemonApp/db/pokemonTypes")
	public List<PokemonTypeId> getPokemonTypes(){
		List<PokemonType> pokemonTypes = pokemonTypeRepository.findAll();
		List<PokemonTypeId> pokemonTypesId = new ArrayList<>();
		for (PokemonType pokemonType : pokemonTypes) {
			pokemonTypesId.add(pokemonType.getId());
		}
		return pokemonTypesId;
	}
	
	@GetMapping("/PokemonApp/db/effectiveTypes")
	public List<TypeEffectiveId> getEffectiveTypes(){
		List<TypeEffective> typesEffective = typeEffectiveRepository.findAll();
		List<TypeEffectiveId> typesEffectiveId = new ArrayList<>();
		for (TypeEffective typeEffective : typesEffective) {
			typesEffectiveId.add(typeEffective.getId());
		}
		return typesEffectiveId;
	}
	
	@GetMapping("/PokemonApp/db/notEffectiveTypes")
	public List<TypeNotEffectiveId> getNotEffectiveTypes(){
		List<TypeNotEffective> typesNotEffective = typeNotEffectiveRepository.findAll();
		List<TypeNotEffectiveId> typesNotEffectiveId = new ArrayList<>();
		for (TypeNotEffective typeNotEffective : typesNotEffective) {
			typesNotEffectiveId.add(typeNotEffective.getId());
		}
		return typesNotEffectiveId;
	}
	
	@GetMapping("/PokemonApp/db/noEffectTypes")
	public List<TypeNoEffectId> getNoEffectTypes(){
		List<TypeNoEffect> typesNoEffect = typeNoEffectRepository.findAll();
		List<TypeNoEffectId> typesNoEffectId = new ArrayList<>();
		for (TypeNoEffect typeNoEffect : typesNoEffect) {
			typesNoEffectId.add(typeNoEffect.getId());
		}
		return typesNoEffectId;
	}
	
	@GetMapping("/PokemonApp/db/pokemonMoves")
	public List<PokemonMoveId> getPokemonMoves(){
		List<PokemonMove> pokemonMoves = pokemonMoveRepository.findAll();
		List<PokemonMoveId> pokemonMovesId = new ArrayList<>();
		for (PokemonMove pokemonMove : pokemonMoves) {
			pokemonMovesId.add(pokemonMove.getId());
		}
		return pokemonMovesId;
	}
	
}
