package com.humberto.pokemon.PokemonApp.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Repositories.MoveRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.MoveDto;

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

	@Override
	protected void setClassVariables() {
		TAG = "moves";
		repository = moveRepository;
	}
	
}
