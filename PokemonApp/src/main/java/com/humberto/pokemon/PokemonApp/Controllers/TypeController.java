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

import com.humberto.pokemon.PokemonApp.Models.Type;
import com.humberto.pokemon.PokemonApp.Repositories.TypeRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.TypeDto;

@Controller
public class TypeController extends ResourceController{
	
	@Autowired
	private TypeRepository typeRepository;
	
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
		return getRelatedEntities(id, model, typeRepository.getById(id).getEffective(),"effectiveType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/notEffectiveType")
	public String getNotEffectiveTypes(@PathVariable Long id, Model model) {
		return getRelatedEntities(id, model, typeRepository.getById(id).getNotEffective(),"notEffectiveType");
	}
	
	@GetMapping("/PokemonApp/types/{id}/noEffectType")
	public String getNoEffectTypes(@PathVariable Long id, Model model) {
		return getRelatedEntities(id, model, typeRepository.getById(id).getNoEffect(),"noEffectType");
	}
	
	@PostMapping("/PokemonApp/types/{id}/effectiveType")
	public String addEffectiveTypes(@Valid TypeDto typeDto, BindingResult result, @PathVariable Long id, Model model) {
		return addInListOfTypes(id, typeDto, new ModifyListInterface() {
			@Override
			public void modify(Type type, Type typeRelated) {
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
			public void modify(Type type, Type typeRelated) {
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
			public void modify(Type type, Type typeRelated) {
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
			public void modify(Type type, Type typeToDelete) {
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
			public void modify(Type type, Type typeToDelete) {
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
			public void modify(Type type, Type typeToDelete) {
				List<Type> relatedTypes = type.getNoEffect();
				relatedTypes.remove(typeToDelete);
				type.setNoEffect(relatedTypes);
			}
		}, "noEffectType");
	}

	public String getRelatedEntities(Long id, Model model, List<Type> relatedTypes, String column) {
		model.addAttribute("column",column);
		model.addAttribute("idType",id);
		model.addAttribute("relatedTypes",relatedTypes);
		return "relatedTypes";
	}
	
	private String addInListOfTypes(Long id, TypeDto typeDto, ModifyListInterface modifyListInterface, String path) {
		Type typeToAdd = typeRepository.getByName(typeDto.getfName());
		Type type = typeRepository.getById(id);
		if (typeToAdd != null && type != null) {
			modifyListInterface.modify(type, typeToAdd);
		}
		return "redirect:/PokemonApp/types/{id}/"+path;
	}
	
	private String deleteFromListOfTypes(Long idType, Long idToDelete, ModifyListInterface modifyListInterface,String path) {
		Type typeToDelete = typeRepository.getById(idToDelete);
		Type type = typeRepository.getById(idType);
		if (typeToDelete != null && type != null) {
			modifyListInterface.modify(type, typeToDelete);
			typeRepository.save(type);
		}
		return "redirect:/PokemonApp/types/{id}/"+path;
	}
	
	@Override
	protected void setClassVariables() {
		TAG = "types";
		repository = typeRepository;
	}
	
	public interface ModifyListInterface {
		void modify(Type type, Type typeRelated);
	}
	
}
