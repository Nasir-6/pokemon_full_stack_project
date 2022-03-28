package com.pokepals.pokemonbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonBackEndApplication.class, args);
		System.out.println("working");
	}

}
