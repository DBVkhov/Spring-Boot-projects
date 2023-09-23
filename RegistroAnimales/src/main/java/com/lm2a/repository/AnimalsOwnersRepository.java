package com.lm2a.repository;

import java.util.List;

import com.lm2a.model.Animals;
import com.lm2a.model.AnimalsOwners;
import com.lm2a.model.Owners;

public interface AnimalsOwnersRepository {
	List<Animals> getOwnersAnimals(int ownerId);
	Owners getAnimalsOwner(int animalId);
	void createOwnership(int animalId, int ownerId);
	void delete(int animalId);
	void updateInfo(AnimalsOwners infoUpdated, Animals animal);
}
