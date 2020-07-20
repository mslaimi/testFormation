package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Personne;

@Controller
public class PersonneController {
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping(value = "/addPerson")
	public String addPerson() {
		return "jsp/addPerson";
	}

	@PostMapping(value = "/addPerson")
	public ModelAndView addPerson(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom) {
		Personne p1 = new Personne(nom, prenom);
		personneRepository.save(p1);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/confirm");
		mv.addObject("nom", nom);
		mv.addObject("prenom", prenom);
		return mv;
	}

	@RequestMapping(value = "/show")
	public ModelAndView showAll() {
		ArrayList<Personne> al = (ArrayList<Personne>) personneRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/result");
		mv.addObject("tab", al);
		return mv;
	}

	@RequestMapping(value = "/showAllByPage/{i}/{j}")
	public ModelAndView showAllByPage(@PathVariable int i, @PathVariable int j) {
		Page<Personne> personnes = personneRepository.findAll(PageRequest.of(i, j));
		List<Personne> liste= personnes.toList();
 		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/result");
		mv.addObject("tab", liste);
		return mv;
	}

	@RequestMapping(value = "/showAllSorted")
	public ModelAndView showAllSorted() {
		List<Personne> personnes = personneRepository.findAll(Sort.by("nom").descending());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/result");
		mv.addObject("tab", personnes);
		return mv;
	}

	@RequestMapping(value = "/showSome")
	public ModelAndView showSome(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom) {
		ArrayList<Personne> al = (ArrayList<Personne>) personneRepository.findByNomAndPrenom(nom, prenom);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/result");
		mv.addObject("tab", al);
		return mv;
	}
}
