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

import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

@Controller
public class TypeController{
	
	@Autowired
	private TypeRepository typeRepository;
	
	@GetMapping("/PokemonApp/types")
	public String type(Model model, TypeDto typeDto) {
		addTypesToModel(model);
		return "types";
	}
	
	@PostMapping("/PokemonApp/types")
	public String createType(@Valid TypeDto typeDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("collapseForm",true);
			addTypesToModel(model);
			return "types";
		}
		typeRepository.save(typeDto.toType());
		return "redirect:/PokemonApp/types";
	}
	
	@GetMapping("/PokemonApp/types/delete/{id}")
	public String deleteType(@PathVariable Long id) {
		typeRepository.deleteById(id);
		return "redirect:/PokemonApp/types";
	}
	
	@GetMapping("/PokemonApp/types/update/{id}")
	public String updateType(@PathVariable Long id, TypeDto typeDto, Model model) {
		Type type = typeRepository.findById(id).get();
		typeDto.fromType(type);
		addTypesToModel(model);
		model.addAttribute("collapseForm",true);
		return "types";
	}
	
	public void addTypesToModel(Model model) {
		List<Type> types = new ArrayList<>();
		types.addAll(typeRepository.findAll());
		model.addAttribute("types",types);
	}
	
}
