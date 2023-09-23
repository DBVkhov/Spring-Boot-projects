package com.lm2a.repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lm2a.model.Ingredient;
import com.lm2a.model.Taco;


@Repository
public class TacoRepositoryImpl implements TacoRepository {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Taco save(Taco design) {
		long tacoId = saveTacoInfo(design);
		design.setId(tacoId);
		for(Ingredient i: design.getIngredients()) {
			saveIngredientToTaco(i, tacoId);
		}
		return design;
	}

	private void saveIngredientToTaco(Ingredient i, long tacoId) {
		jdbc.update("INSERT INTO Taco_Ingredients(taco, ingredient) VALUES(?, ?)", tacoId, i.getId());
		
	}

	private long saveTacoInfo(Taco design) {
		design.setCreatedAt(new Date());
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory("INSERT INTO Taco(name, createdAt) VALUES(?, ?)", Types.VARCHAR, Types.TIMESTAMP);
		pscf.setReturnGeneratedKeys(true);
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(design.getName(), new Timestamp(design.getCreatedAt().getTime())));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);
		Number n = keyHolder.getKey();
		
		return n.longValue();
	}

}
