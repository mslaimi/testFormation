package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Personne;

@RestController
public class PersonneRestController {
	@Autowired
	private PersonneRepository personneRepository;
	@GetMapping("/personnes")
	public List<Personne> getPersonnes() {
	return personneRepository.findAll();
	}
	@GetMapping("/personnes/{id}")
	public Personne getPersonne(@PathVariable("id") int id) {
	return personneRepository.findById((long)id).orElse(null);
	}
	@PostMapping("/personnes")
	public Personne addPersonne(@RequestBody Personne personne) {
	System.out.println(personne);
	return personneRepository.save(personne);
	}
}
