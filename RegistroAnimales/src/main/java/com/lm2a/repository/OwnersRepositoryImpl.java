package com.lm2a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lm2a.model.Owners;

@Repository
public class OwnersRepositoryImpl implements OwnersRepository {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<Owners> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owners getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Owners owner) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeInfo(Owners owner, int id) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
