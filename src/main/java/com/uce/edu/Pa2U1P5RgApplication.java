package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P5RgApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5RgApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		System.out.println("Hola Mundo ");
		System.out.println("Soy Jose Jimenez y Romina Guevara");
		System.out.println("Cambio en la misma Rama");
		System.out.println("Este es un cambio para un taller 4 ");
	}
}

