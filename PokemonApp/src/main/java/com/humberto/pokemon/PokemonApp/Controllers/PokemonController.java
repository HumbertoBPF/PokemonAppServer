package com.humberto.pokemon.PokemonApp.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Repositories.PokemonRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.PokemonDto;

@Controller
public class PokemonController extends ResourceController{

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@GetMapping("PokemonApp/pokemon")
	private String pokemon(Model model, PokemonDto pokemonDto) {
		return get(model, pokemonDto);
	}
	
	@PostMapping("/PokemonApp/pokemon")
	public String createType(@Valid PokemonDto pokemonDto, BindingResult result, Model model) {
		return post(pokemonDto, result, model);
	}
	
	@GetMapping("/PokemonApp/pokemon/delete/{id}")
	public String deleteType(@PathVariable Long id) {
		return delete(id);
	}
	
	@GetMapping("/PokemonApp/pokemon/update/{id}")
	public String updateType(PokemonDto pokemonDto, @PathVariable Long id, Model model) {
		return put(pokemonDto,id,model);
	}

	@Override
	protected void setClassVariables() {
		TAG = "pokemon";
		repository = pokemonRepository;
	}
	
}
