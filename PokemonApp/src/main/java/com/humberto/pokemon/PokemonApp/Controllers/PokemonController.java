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

import com.humberto.pokemon.PokemonApp.Models.Pokemon;
import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.PokemonRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.PokemonDto;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

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
	
	@GetMapping("/PokemonApp/pokemon/{id}/types")
	public String getTypes(@PathVariable Long id, Model model) {
		return getRelatedTypes(id, model, pokemonRepository.getById(id).getType(),"types");
	}
	
	@PostMapping("/PokemonApp/pokemon/{id}/types")
	public String addTypes(@Valid TypeDto typeDto, BindingResult result, @PathVariable Long id, Model model) {
		return addInListOfTypes(id, typeDto, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Type typeRelated) {
				Pokemon pokemon = (Pokemon) entity;
				List<Type> relatedTypes = pokemon.getType();
				if (!relatedTypes.contains(typeRelated)) {
					relatedTypes.add(typeRelated);
					pokemon.setType(relatedTypes);
					pokemonRepository.save(pokemon);
				}
			}
		},"types");
	}
	
	@GetMapping("/PokemonApp/pokemon/{id}/types/delete/{idRelated}")
	public String deleteTypes(@PathVariable Long id, @PathVariable Long idRelated, Model model) {
		return deleteFromListOfTypes(id, idRelated, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Type typeToDelete) {
				Pokemon pokemon = (Pokemon) entity;
				List<Type> relatedTypes = pokemon.getType();
				relatedTypes.remove(typeToDelete);
				pokemon.setType(relatedTypes);
			}
		}, "types");
	}
	
	@Override
	protected void setClassVariables() {
		TAG = "pokemon";
		repository = pokemonRepository;
	}
	
}
