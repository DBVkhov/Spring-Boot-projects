package com.lm2a.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	private Long id;
	@Size(min=5, message="El nombre debe tener al menos 5 caracteres")
	private String name;
	private Date createdAt;
	private List<Ingredient> ingredients;

}
