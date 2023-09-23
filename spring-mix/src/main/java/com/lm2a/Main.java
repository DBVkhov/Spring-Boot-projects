package com.lm2a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext contexto = new AnnotationConfigApplicationContext(Config.class);
		
		Parrot parrot = contexto.getBean(Parrot.class);
		Person person = contexto.getBean(Person.class);
		
		System.out.println("El nombre de la persona es: "+person.getName());
		System.out.println("El nombre del loro es: "+parrot.getName());
		System.out.println("El loro de la persona es: "+person.getParrot());
		
		((ConfigurableApplicationContext) contexto).close();
	}

}
