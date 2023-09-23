package com.lm2a.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm2a.model.Order;
import com.lm2a.model.Taco;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	JdbcTemplate jdbc;
	private SimpleJdbcInsert orderInserter;
	private SimpleJdbcInsert orderTacoInserter;
	private ObjectMapper objectMapper;
	
	public OrderRepositoryImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		orderInserter = new SimpleJdbcInsert(jdbc).withTableName("Taco_order").usingGeneratedKeyColumns("id");
		orderTacoInserter = new SimpleJdbcInsert(jdbc).withTableName("Taco_Order_Tacos");
		objectMapper = new ObjectMapper();
	}

	@Override
	public Order save(Order order) {
		order.setPlacedAt(new Date());
		long orderId = saveOrderDetails(order);
		order.setId(orderId);
		List<Taco> tacos = order.getTacos();
		for(Taco taco: tacos) {
			saveTacoToOrder(taco, orderId);
		}
		return order;
	}

	private long saveOrderDetails(Order order) {
		@SuppressWarnings("unchecked")
		Map<String, Object> values = objectMapper.convertValue(order, Map.class);
		values.put("placedAt", order.getPlacedAt());
		
		long orderId = orderInserter.executeAndReturnKey(values).longValue();
		return orderId;
	}

	private void saveTacoToOrder(Taco taco, long orderId) {
		Map<String, Object> values = new HashMap<>();
		values.put("tacoOrder", orderId);
		values.put("taco", taco.getId());
		orderTacoInserter.execute(values);
	}

}
