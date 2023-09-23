package com.lm2a.repository;

import java.util.List;
import com.lm2a.model.Owners;

public interface OwnersRepository {
	List<Owners> getAll();
	Owners getByID(int id);
	void create(Owners owner);
	void changeInfo(Owners owner, int id);
	void delete(int id);
}
