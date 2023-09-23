package com.lm2a.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lm2a.model.Ingredient;
import com.lm2a.model.Ingredient.Type;
import com.lm2a.model.Order;
import com.lm2a.model.Taco;
import com.lm2a.repository.IngredientRepository;
import com.lm2a.repository.TacoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private TacoRepository tacoRepository;
	
	@GetMapping
	public String showDesignForm(Model model) {
 		//int x = 1/0;
		fillIngredients(model);
		//model.addAttribute("tktn", new Taco());
		return "design";
	}
	
	@ModelAttribute(name="tktn")
	public Taco taco() {
		return new Taco();
	}
	
	@ModelAttribute(name="order")
	public Order order() {
		return new Order();
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

		return ingredients.stream()
				.filter(i -> i.getType().equals(type))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processDesign(@Valid @ModelAttribute(name = "tktn") Taco design, Errors errors, Model model, @ModelAttribute Order order) {
		if(errors.hasErrors()) {
			fillIngredients(model);
			return "design";
		}
		
		//guardar el taco -> persistencia
		tacoRepository.save(design);
		order.addDesign(design);
		
		log.info("Nos ha entrado el siguiente Taco: "+design);
		return "redirect:/orders/current";
		
	}
	
//	private void fillIngredients(Model model) {
//		List<Ingredient> ingredients = Arrays.asList(
//				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//				new Ingredient("COTO", "Corn Tortilla", Type.WRAP), 
//				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//				new Ingredient("CARN", "Carnitas", Type.PROTEIN), 
//				new Ingredient("LETC", "Lechuga", Type.VEGGIES),
//				new Ingredient("TMTO", "Diced Tomaoes", Type.VEGGIES), 
//				new Ingredient("CHED", "Cheddar", Type.CHEESE),
//				new Ingredient("JACK", "Monterrey Jack", Type.CHEESE), 
//				new Ingredient("SLSA", "Salsa", Type.SAUCE),
//				new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//		
//		Type[] types = Ingredient.Type.values();
//		for(Type type: types) {
//			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
//		}
//	}
	
	private void fillIngredients(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(i->ingredients.add(i));
		Type[] types = Ingredient.Type.values();
		for(Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}
	
}
