package com.humberto.pokemon.PokemonApp.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

@Controller
public class TypeController extends ResourceController{
	
	@Autowired
	private TypeRepository typeRepository;
	
	@GetMapping("/PokemonApp/types")
	public String type(Model model, TypeDto typeDto) {
		return get(model, typeDto);
	}
	
	@PostMapping("/PokemonApp/types")
	public String createType(@Valid TypeDto typeDto, BindingResult result, Model model) {
		return post(typeDto, result, model);
	}
	
	@GetMapping("/PokemonApp/types/delete/{id}")
	public String deleteType(@PathVariable Long id) {
		return delete(id);
	}
	
	@GetMapping("/PokemonApp/types/update/{id}")
	public String updateType(TypeDto typeDto, @PathVariable Long id, Model model) {
		return put(typeDto, id, model);
	}

	@Override
	protected void setClassVariables() {
		TAG = "types";
		repository = typeRepository;
	}
	
}
