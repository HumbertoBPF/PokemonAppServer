package com.humberto.pokemon.PokemonApp.Util;

import java.util.List;

import com.humberto.pokemon.PokemonApp.Models.Move;
import com.humberto.pokemon.PokemonApp.Models.Type;

public class Tools {

	public static String listOfTypesAsString(List<Type> types) {
		String stringTypes = "";
		for (Type type : types) {
			stringTypes += type.getName() + ",";
		}
		return stringTypes;
	}
	
	public static String listOfMovesAsString(List<Move> moves) {
		String stringMoves = "";
		for (Move move : moves) {
			stringMoves += move.getName() + ",";
		}
		return stringMoves;
	}
	
}
