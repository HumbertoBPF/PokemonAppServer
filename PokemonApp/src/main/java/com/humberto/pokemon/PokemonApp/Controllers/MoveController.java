package com.humberto.pokemon.PokemonApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.humberto.pokemon.PokemonApp.Models.Move;
import com.humberto.pokemon.PokemonApp.Repositories.MoveRepository;
import com.humberto.pokemon.PokemonApp.RequestModels.MoveDto;

@Controller
public class MoveController {

	@Autowired
	public MoveRepository moveRepository;
	
	@GetMapping("/PokemonApp/moves")
	public String move(Model model, MoveDto moveDto) {
		addMovesToModel(model);
		return "moves";
	}
	
	@PostMapping("/PokemonApp/moves")
	public String createType(MoveDto moveDto) {
		moveRepository.save(moveDto.toMove());
		return "redirect:/PokemonApp/moves";
	}
	
	@GetMapping("/PokemonApp/moves/delete/{id}")
	public String deleteType(@PathVariable Long id) {
		moveRepository.deleteById(id);
		return "redirect:/PokemonApp/moves";
	}
	
	@GetMapping("/PokemonApp/moves/update/{id}")
	public String updateType(@PathVariable Long id, MoveDto moveDto, Model model) {
		Move move = moveRepository.findById(id).get();
		moveDto.fromMove(move);
		addMovesToModel(model);
		model.addAttribute("collapseForm",true);
		return "moves";
	}
	
	public void addMovesToModel(Model model) {
		List<Move> moves = new ArrayList<>();
		moves.addAll(moveRepository.findAll());
		model.addAttribute("moves",moves);
	}
	
}
