package com.lm2a;

public class Main {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance("Java");
		
		Singleton s2 = Singleton.getInstance("Python");

		System.out.println(s1.value);
		
		System.out.println(s2.value);
	}

}
