package com.lm2a.model;

import java.sql.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Animals {

	private final int id;
	private final int identification;
	private final String name;
	private final String race;
	private final float weight;
	private final String vaccines;
	private final String description;
	private final Date birthday;
	
}
