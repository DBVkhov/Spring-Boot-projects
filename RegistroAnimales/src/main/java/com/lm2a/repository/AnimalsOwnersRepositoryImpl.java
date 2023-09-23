package com.lm2a.repository;

import java.util.List;

import com.lm2a.model.Animals;
import com.lm2a.model.AnimalsOwners;
import com.lm2a.model.Owners;

public class AnimalsOwnersRepositoryImpl implements AnimalsOwnersRepository {

	@Override
	public List<Animals> getOwnersAnimals(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owners getAnimalsOwner(int animalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOwnership(int animalId, int ownerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int animalId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInfo(AnimalsOwners infoUpdated, Animals animal) {
		// TODO Auto-generated method stub

	}

}
