package com.lm2a.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lm2a.model.Animals;
import com.lm2a.model.Ingredient;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<Animals> getAllAnimals() {
		return jdbc.query("SELECT id, identification, name, race, weight, vaccines, description, birthday FROM Animals", this::mapRowToAnimals);
	}

	@Override
	public Animals getByID(int id) {
		return jdbc.queryForObject("SELECT id, name, type FROM Ingredient WHERE id=?", this::mapRowToAnimals, id);
	}

	@Override
	public void create(Animals animal) {
		jdbc.update("INSERT INTO Ingredient(id, name, type) VALUES(?,?,?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());

	}

	@Override
	public void changeInfo(Animals animal) {
		jdbc.update("UPDATE INTO Animals SET identification = ?, name = ?, race = ?, weight = ?, vaccines = ?, description = ?, birthday = ? WHERE id = ?", 
				animal.getDescription(), animal.getName(), animal.getRace(), animal.getWeight(), animal.getVaccines(), animal.getDescription(), animal.getBirthday(), animal.getId());
	}

	@Override
	public void delete(int id) {
		jdbc.update("DELETE FROM Animals WHERE id=?", id);

	}
	
	private Animals mapRowToAnimals(ResultSet rs, int rowNum) throws SQLException {
		return new Animals(rs.getInt("id"), 
				rs.getInt("Identification"), 
				rs.getString("name"), 
				rs.getString("race"), 
				rs.getFloat("weight"), 
				rs.getString("vaccines"), 
				rs.getString("description"), 
				rs.getDate("birthday"));
	}

}
