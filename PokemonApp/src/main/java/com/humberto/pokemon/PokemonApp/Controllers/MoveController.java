package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Models.Move;
import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.MoveRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.MoveDto;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

@Controller
public class MoveController extends ResourceController{

	@Autowired
	public MoveRepository moveRepository;
	
	@GetMapping("/PokemonApp/moves")
	public String move(Model model, MoveDto moveDto) {
		return get(model, moveDto);
	}
	
	@PostMapping("/PokemonApp/moves")
	public String createType(@Valid MoveDto moveDto, BindingResult result, Model model) {
		return post(moveDto, result, model);
	}
	
	@GetMapping("/PokemonApp/moves/delete/{id}")
	public String deleteType(@PathVariable Long id) {
		return delete(id);
	}
	
	@GetMapping("/PokemonApp/moves/update/{id}")
	public String updateType(MoveDto moveDto, @PathVariable Long id, Model model) {
		return put(moveDto,id,model);
	}

	@GetMapping("/PokemonApp/moves/{id}/types")
	public String getTypes(@PathVariable Long id, Model model) {
		return getRelatedTypes(id, model, moveRepository.getById(id).getType(),"types");
	}
	
	@PostMapping("/PokemonApp/moves/{id}/types")
	public String addTypes(@Valid TypeDto typeDto, BindingResult result, @PathVariable Long id, Model model) {
		return addInListOfTypes(id, typeDto, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Type typeRelated) {
				Move move = (Move) entity;
				List<Type> relatedTypes = move.getType();
				if (!relatedTypes.contains(typeRelated)) {
					relatedTypes.add(typeRelated);
					move.setType(relatedTypes);
					moveRepository.save(move);
				}
			}
		},"types");
	}
	
	@GetMapping("/PokemonApp/moves/{id}/types/delete/{idRelated}")
	public String deleteTypes(@PathVariable Long id, @PathVariable Long idRelated, Model model) {
		return deleteFromListOfTypes(id, idRelated, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Type typeToDelete) {
				Move move = (Move) entity;
				List<Type> relatedTypes = move.getType();
				relatedTypes.remove(typeToDelete);
				move.setType(relatedTypes);
			}
		},"types");
	}
	
	@Override
	protected void setClassVariables() {
		TAG = "moves";
		repository = moveRepository;
	}
	
}
