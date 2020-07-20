package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.EmprunteurService;

@Controller
public class EmprunteurController {
	@Autowired
	private EmprunteurService empService;

	@GetMapping(value = "/ajoutEmprunteur")
	public String addPerson(Model model) {
		
		return "jsp/addEmprunteur";
	}

}
