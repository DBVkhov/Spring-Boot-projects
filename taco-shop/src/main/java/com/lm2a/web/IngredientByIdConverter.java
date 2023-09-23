package com.lm2a.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lm2a.model.Ingredient;
import com.lm2a.repository.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Override
	public Ingredient convert(String id) {
		return ingredientRepository.findOne(id);
	}

}
