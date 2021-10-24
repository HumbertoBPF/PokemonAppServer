package com.humberto.pokemon.PokemonApp.Util;

import java.util.List;

import com.humberto.pokemon.PokemonApp.Models.Type;

public class Tools {

	public static String listOfTypesAsString(List<Type> types) {
		String stringNoEffectTypes = "";
		for (Type type : types) {
			stringNoEffectTypes += type.getName() + ",";
		}
		return stringNoEffectTypes;
	}
	
}
