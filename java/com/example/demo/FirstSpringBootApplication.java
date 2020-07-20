package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Personne;

@SpringBootApplication
public class FirstSpringBootApplication //implements ApplicationRunner 
{
	@Autowired
	private PersonneRepository personneRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}
	//@Override
	//public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		/*Personne personne1 = new Personne("wick", "luc");
		Personne personne2 = new Personne("dalton", "averell");
		personneRepository.save(personne1);
		personneRepository.save(personne2);*/
	//}

}
