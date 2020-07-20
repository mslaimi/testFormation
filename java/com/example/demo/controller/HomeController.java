package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping(value = "/hello")
	public String sayHello(@RequestParam(value = "nom", required = false) String nom, Model model) {
		model.addAttribute("nom", nom);
		return "jsp/hello";
	}
}
