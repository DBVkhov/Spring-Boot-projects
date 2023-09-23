package com.lm2a.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class AnimalsOwners {
	
	private final int id;
	private final int idowner;
	private final int idanimal;
	
}
