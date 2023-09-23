package com.lm2a.model;
import java.sql.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Owners {
	private final int id;
	private final String fullname;
	private final String identification;
	private final String address;
	private final int phone;
	private final Date birthday;
}
