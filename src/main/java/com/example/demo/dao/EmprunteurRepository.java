package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Emprunteur;

public interface EmprunteurRepository extends JpaRepository<Emprunteur, Integer> {
	Emprunteur findByNomAndPrenom(String nom, String prenom);
}
