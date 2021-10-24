package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.Dto;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

public abstract class ResourceController {
	
	protected String TAG;
	protected JpaRepository repository;
	@Autowired
	protected TypeRepository typeRepository;
	
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
	
	protected String getRelatedTypes(Long id, Model model, List<Type> relatedTypes, String column) {
		setClassVariables();
		model.addAttribute("entityBase",TAG);
		model.addAttribute("column",column);
		model.addAttribute("idType",id);
		model.addAttribute("relatedTypes",relatedTypes);
		return "relatedTypes";
	}
	
	protected String addInListOfTypes(Long id, TypeDto typeDto, ModifyListInterface modifyListInterface, String path) {
		setClassVariables();
		Type typeToAdd = typeRepository.getByName(typeDto.getfName());
		Object entity = repository.getById(id);
		if (typeToAdd != null && entity != null) {
			modifyListInterface.modify(entity, typeToAdd);
		}
		return "redirect:/PokemonApp/"+TAG+"/{id}/"+path;
	}
	
	protected String deleteFromListOfTypes(Long id, Long idToDelete, ModifyListInterface modifyListInterface,String path) {
		setClassVariables();
		Type typeToDelete = typeRepository.getById(idToDelete);
		Object entity = repository.getById(id);
		if (typeToDelete != null && entity != null) {
			modifyListInterface.modify(entity, typeToDelete);
			repository.save(entity);
		}
		return "redirect:/PokemonApp/"+TAG+"/{id}/"+path;
	}
	
	protected interface ModifyListInterface {
		void modify(Object entity, Type typeRelated);
	}
	
}
