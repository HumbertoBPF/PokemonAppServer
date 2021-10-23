package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.humberto.pokemon.PokemonApp.RequestModels.Dto;

public abstract class ResourceController {
	
	protected String TAG;
	protected JpaRepository repository;
	
	protected abstract void setClassVariables();
	
	protected String get(Model model, Dto dto) {
		setClassVariables();
		addEntityToModel(model);
		return TAG;
	}
	
	protected String post(@Valid Dto dto, BindingResult result, Model model) {
		setClassVariables();
		if (result.hasErrors()) {
			model.addAttribute("collapseForm",true);
			addEntityToModel(model);
			return TAG;
		}
		repository.save(dto.toEntity());
		return "redirect:/PokemonApp/"+TAG;
	}
	
	protected String put(Dto dto, Long id, Model model) {
		setClassVariables();
		dto.fromEntity(repository.findById(id).get());
		addEntityToModel(model);
		model.addAttribute("collapseForm",true);
		return TAG;
	}
	
	protected String delete(Long id) {
		setClassVariables();
		repository.deleteById(id);
		return "redirect:/PokemonApp/"+TAG;
	}
	
	protected void addEntityToModel(Model model) {
		List<Object> entities = new ArrayList<>();
		entities.addAll(repository.findAll());
		model.addAttribute(TAG,entities);
	}
	
}
