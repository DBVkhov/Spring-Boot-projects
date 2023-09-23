package com.lm2a.model;

public class User {
	private String name;
	private String lastName;
	private String dni;
	private int birthYear;
	
	public User(String name, String lastName, String dni, int birthYear) {
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.birthYear = birthYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastName=" + lastName + ", dni=" + dni + ", birthYear=" + birthYear + "]";
	}
	
	

}
