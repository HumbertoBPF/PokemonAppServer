package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

@Controller
public class TypeController extends ResourceController{
	
	@GetMapping("/PokemonApp/types")
	public String getType(Model model, TypeDto typeDto) {
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
	
	@GetMapping("/PokemonApp/types/{id}/effectiveType")
	public String getEffectiveTypes(@PathVariable Long id, Model model) {
		setClassVariables();
		return getRelatedTypes(id, model, typeRepository.getById(id).getEffective(),"effectiveType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/notEffectiveType")
	public String getNotEffectiveTypes(@PathVariable Long id, Model model) {
		return getRelatedTypes(id, model, typeRepository.getById(id).getNotEffective(),"notEffectiveType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/noEffectType")
	public String getNoEffectTypes(@PathVariable Long id, Model model) {
		return getRelatedTypes(id, model, typeRepository.getById(id).getNoEffect(),"noEffectType");
	}
	
	@PostMapping("/PokemonApp/types/{id}/effectiveType")
	public String addEffectiveTypes(@Valid TypeDto typeDto, BindingResult result, @PathVariable Long id, Model model) {
		return addInListOfTypes(id, typeDto, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Object entityRelated) {
				Type type = (Type) entity;
				Type typeRelated = (Type) entityRelated;
				List<Type> relatedTypes = type.getEffective();
				if (!relatedTypes.contains(typeRelated)) {
					relatedTypes.add(typeRelated);
					type.setEffective(relatedTypes);
					typeRepository.save(type);
				}
			}
		},"effectiveType");
	}
	
	@PostMapping("/PokemonApp/types/{id}/notEffectiveType")
	public String addNotEffectiveTypes(@Valid TypeDto typeDto, BindingResult result, @PathVariable Long id, Model model) {
		return addInListOfTypes(id, typeDto, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Object entityRelated) {
				Type type = (Type) entity;
				Type typeRelated = (Type) entityRelated;
				List<Type> relatedTypes = type.getNotEffective();
				if (!relatedTypes.contains(typeRelated)) {
					relatedTypes.add(typeRelated);
					type.setNotEffective(relatedTypes);
					typeRepository.save(type);
				}
			}
		},"notEffectiveType");
	}
	
	@PostMapping("/PokemonApp/types/{id}/noEffectType")
	public String addNoEffectTypes(@Valid TypeDto typeDto, BindingResult result, @PathVariable Long id, Model model) {
		return addInListOfTypes(id, typeDto, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Object entityRelated) {
				Type type = (Type) entity;
				Type typeRelated = (Type) entityRelated;
				List<Type> relatedTypes = type.getNoEffect();
				if (!relatedTypes.contains(typeRelated)) {
					relatedTypes.add(typeRelated);
					type.setNoEffect(relatedTypes);
					typeRepository.save(type);
				}
			}
		},"noEffectType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/effectiveType/delete/{idRelated}")
	public String deleteEffectiveTypes(@PathVariable Long id, @PathVariable Long idRelated, Model model) {
		return deleteFromListOfTypes(id, idRelated, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Object entityRelated) {
				Type type = (Type) entity;
				Type typeToDelete = (Type) entityRelated;
				List<Type> relatedTypes = type.getEffective();
				relatedTypes.remove(typeToDelete);
				type.setEffective(relatedTypes);
			}
		}, "effectiveType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/notEffectiveType/delete/{idRelated}")
	public String deleteNotEffectiveTypes(@PathVariable Long id, @PathVariable Long idRelated, Model model) {
		return deleteFromListOfTypes(id, idRelated, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Object entityRelated) {
				Type type = (Type) entity;
				Type typeToDelete = (Type) entityRelated;
				List<Type> relatedTypes = type.getNotEffective();
				relatedTypes.remove(typeToDelete);
				type.setNotEffective(relatedTypes);
			}
		}, "notEffectiveType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/noEffectType/delete/{idRelated}")
	public String deleteNoEffectTypes(@PathVariable Long id, @PathVariable Long idRelated, Model model) {
		return deleteFromListOfTypes(id, idRelated, new ModifyListInterface() {
			@Override
			public void modify(Object entity, Object entityRelated) {
				Type type = (Type) entity;
				Type typeToDelete = (Type) entityRelated;
				List<Type> relatedTypes = type.getNoEffect();
				relatedTypes.remove(typeToDelete);
				type.setNoEffect(relatedTypes);
			}
		}, "noEffectType");
	}
	
	@Override
	protected void setClassVariables() {
		TAG = "types";
		repository = typeRepository;
	}
	
}
