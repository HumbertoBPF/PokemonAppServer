package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Models.Pokemon;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.PokemonDto;

@Controller
public class PokemonController {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@GetMapping("PokemonApp/pokemon")
	private String pokemon(Model model, PokemonDto pokemonDto) {
		addPokemonToModel(model);
		return "pokemon";
	}
	
	@PostMapping("/PokemonApp/pokemon")
	public String createType(@Valid PokemonDto pokemonDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("collapseForm",true);
			addPokemonToModel(model);
			return "pokemon";
		}
		System.out.println(pokemonDto.getfDescription());
		pokemonRepository.save(pokemonDto.toPokemon());
		return "redirect:/PokemonApp/pokemon";
	}
	
	@GetMapping("/PokemonApp/pokemon/delete/{id}")
	public String deleteType(@PathVariable Long id) {
		pokemonRepository.deleteById(id);
		return "redirect:/PokemonApp/pokemon";
	}
	
	@GetMapping("/PokemonApp/pokemon/update/{id}")
	public String updateType(@PathVariable Long id, PokemonDto pokemonDto, Model model) {
		Pokemon pokemon = pokemonRepository.findById(id).get();
		pokemonDto.fromPokemon(pokemon);
		addPokemonToModel(model);
		model.addAttribute("collapseForm",true);
		return "pokemon";
	}
	
	public void addPokemonToModel(Model model) {
		List<Pokemon> pokemon = new ArrayList<>();
		pokemon.addAll(pokemonRepository.findAll());
		model.addAttribute("pokemon",pokemon);
	}
	
}
