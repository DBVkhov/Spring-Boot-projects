package com.lm2a.repository;

import java.util.List;

import com.lm2a.model.Animals;

public interface AnimalsRepository {
	List<Animals> getAllAnimals();
	Animals getByID(int id);
	void create(Animals animal);
	void changeInfo(Animals animal, int id);
	void delete(int id);
	void changeInfo(Animals animal);
}